package com.utez.edu.cursos.password;

import com.utez.edu.cursos.Entity.UsuariosEntity;
import com.utez.edu.cursos.Repository.UsuariosRepository;
import com.utez.edu.cursos.passwordReset.EmailService;
import com.utez.edu.cursos.passwordReset.PasswordResetToken;
import com.utez.edu.cursos.passwordReset.PasswordResetTokenRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class PasswordResetService {

    @Autowired
    private UsuariosRepository usuarioRepository;

    @Autowired
    private PasswordResetTokenRepository tokenRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordEncoder encoder;

    public void requestReset(String email) throws MessagingException {
        Optional<UsuariosEntity> userOpt = usuarioRepository.findByCorreo(email);
        if (userOpt.isEmpty()) return;

        UsuariosEntity user = userOpt.get();
        String token = UUID.randomUUID().toString();
        LocalDateTime expiration = LocalDateTime.now().plusMinutes(30);

        PasswordResetToken resetToken = new PasswordResetToken(token, expiration, user);
        tokenRepository.save(resetToken);

        emailService.sendResetPasswordEmail(email, token);
    }

    public boolean resetPassword(String token, String newPassword) {
        Optional<PasswordResetToken> tokenOpt = tokenRepository.findByToken(token);
        if (tokenOpt.isEmpty()) return false;

        PasswordResetToken resetToken = tokenOpt.get();
        if (resetToken.getExpirationDate().isBefore(LocalDateTime.now())) {
            tokenRepository.delete(resetToken);
            return false;
        }

        UsuariosEntity user = resetToken.getUser();
        user.setContraseña(encoder.encode(newPassword));
        usuarioRepository.save(user);
        tokenRepository.delete(resetToken);

        return true;
    }
}
