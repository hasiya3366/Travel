package com.example.TravelApp.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async // 🎯 මේක දැම්මාම බුකින් එක හිරවෙන්නේ නැතුව බැක්ග්‍රවුන්ඩ් එකෙන් ඉමේල් එක ලස්සනට යනවා!
    public void sendBookingSuccessEmail(String toEmail, String userName, String packageName, double price) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

            // 💡 ඔයාගේ ඇත්තම Gmail එක මෙතනට ඇතුළත් කළා
            helper.setFrom("travel.genie51@gmail.com");
            helper.setTo(toEmail);
            helper.setSubject("Booking Confirmed! 🎉 - TravelApp");

            String htmlContent = "<div style=\"background-color: #1a1e21; padding: 30px; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; color: #dee2e6; max-width: 600px; margin: 0 auto; border-radius: 8px;\">" +
                    "  <div style=\"background-color: #0f766e; color: #ffffff; padding: 20px; border-radius: 6px 6px 0 0; text-align: center; font-size: 22px; font-weight: bold;\">" +
                    "    ✓ Booking Successful!" +
                    "  </div>" +
                    "  <div style=\"padding: 20px 10px;\">" +
                    "    <p style=\"font-size: 16px; color: #ffffff;\">Hello " + userName + ",</p>" +
                    "    <p style=\"font-size: 14px; line-height: 1.6; color: #adb5bd;\">Thank you for booking with TravelApp! Your adventure has been successfully reserved and your details have been confirmed by our team.</p>" +
                    "    <p style=\"font-size: 14px; line-height: 1.6; color: #adb5bd;\">Below is a summary of your booked travel package. If you have any questions or need immediate assistance, feel free to contact us directly.</p>" +
                    "  </div>" +
                    "  <div style=\"background-color: #212529; border: 1px solid #2c3034; border-left: 4px solid #0f766e; padding: 20px; border-radius: 4px; margin-bottom: 25px;\">" +
                    "    <h4 style=\"margin-top: 0; color: #0f766e; font-size: 16px; margin-bottom: 12px;\">Your Booking Summary:</h4>" +
                    "    <p style=\"margin: 6px 0; font-size: 14px;\"><strong style=\"color: #ffffff;\">Package:</strong> " + packageName + "</p>" +
                    "    <p style=\"margin: 6px 0; font-size: 14px;\"><strong style=\"color: #ffffff;\">Total Paid:</strong> LKR " + String.format("%,.2f", price) + "</p>" +
                    "    <p style=\"margin: 6px 0; font-size: 14px;\"><strong style=\"color: #ffffff;\">Status:</strong> Confirmed</p>" +
                    "  </div>" +
                    "  <hr style=\"border: 0; border-top: 1px solid #2c3034; margin-bottom: 20px;\">" +
                    "  <div style=\"font-size: 13px; color: #6c757d; line-height: 1.6;\">" +
                    "    <p style=\"margin: 5px 0;\"><strong style=\"color: #adb5bd;\">Have questions?</strong> Check out our FAQ or visit our website: <a href=\"https://travelapp-production-31c0.up.railway.app/\" style=\"color: #0f766e; text-decoration: none; font-weight: bold;\">TravelApp.com</a></p>" +
                    "    <p style=\"margin: 15px 0 5px 0; font-weight: bold; color: #adb5bd;\">Best regards,</p>" +
                    "    <p style=\"margin: 0; font-weight: bold; color: #ffffff;\">The TravelApp Team</p>" +
                    "  </div>" +
                    "</div>";

            helper.setText(htmlContent, true);

            mailSender.send(mimeMessage);
            System.out.println("📧 Beautiful HTML Booking Email Sent to: " + toEmail);

        } catch (Exception e) {
            System.out.println("❌ Failed to send HTML email: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
