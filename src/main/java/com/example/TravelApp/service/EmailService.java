// package com.example.TravelApp.service;

// import jakarta.mail.internet.MimeMessage;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.scheduling.annotation.Async;
// import org.springframework.stereotype.Service;

// @Service
// public class EmailService {

//     private final JavaMailSender mailSender;

//     public EmailService(JavaMailSender mailSender) {
//         this.mailSender = mailSender;
//     }

//     @Async // 🎯 මේක දැම්මාම බුකින් එක හිරවෙන්නේ නැතුව බැක්ග්‍රවුන්ඩ් එකෙන් ඉමේල් එක ලස්සනට යනවා!
//     public void sendBookingSuccessEmail(String toEmail, String userName, String packageName, double price) {
//         try {
//             MimeMessage mimeMessage = mailSender.createMimeMessage();
//             MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

//             // 💡 ඔයාගේ ඇත්තම Gmail එක මෙතනට ඇතුළත් කළා
//             helper.setFrom("travel.genie51@gmail.com");
//             helper.setTo(toEmail);
//             helper.setSubject("Booking Confirmed! 🎉 - TravelApp");

//             String htmlContent = "<div style=\"background-color: #1a1e21; padding: 30px; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; color: #dee2e6; max-width: 600px; margin: 0 auto; border-radius: 8px;\">" +
//                     "  <div style=\"background-color: #0f766e; color: #ffffff; padding: 20px; border-radius: 6px 6px 0 0; text-align: center; font-size: 22px; font-weight: bold;\">" +
//                     "    ✓ Booking Successful!" +
//                     "  </div>" +
//                     "  <div style=\"padding: 20px 10px;\">" +
//                     "    <p style=\"font-size: 16px; color: #ffffff;\">Hello " + userName + ",</p>" +
//                     "    <p style=\"font-size: 14px; line-height: 1.6; color: #adb5bd;\">Thank you for booking with TravelApp! Your adventure has been successfully reserved and your details have been confirmed by our team.</p>" +
//                     "    <p style=\"font-size: 14px; line-height: 1.6; color: #adb5bd;\">Below is a summary of your booked travel package. If you have any questions or need immediate assistance, feel free to contact us directly.</p>" +
//                     "  </div>" +
//                     "  <div style=\"background-color: #212529; border: 1px solid #2c3034; border-left: 4px solid #0f766e; padding: 20px; border-radius: 4px; margin-bottom: 25px;\">" +
//                     "    <h4 style=\"margin-top: 0; color: #0f766e; font-size: 16px; margin-bottom: 12px;\">Your Booking Summary:</h4>" +
//                     "    <p style=\"margin: 6px 0; font-size: 14px;\"><strong style=\"color: #ffffff;\">Package:</strong> " + packageName + "</p>" +
//                     "    <p style=\"margin: 6px 0; font-size: 14px;\"><strong style=\"color: #ffffff;\">Total Paid:</strong> LKR " + String.format("%,.2f", price) + "</p>" +
//                     "    <p style=\"margin: 6px 0; font-size: 14px;\"><strong style=\"color: #ffffff;\">Status:</strong> Confirmed</p>" +
//                     "  </div>" +
//                     "  <hr style=\"border: 0; border-top: 1px solid #2c3034; margin-bottom: 20px;\">" +
//                     "  <div style=\"font-size: 13px; color: #6c757d; line-height: 1.6;\">" +
//                     "    <p style=\"margin: 5px 0;\"><strong style=\"color: #adb5bd;\">Have questions?</strong> Check out our FAQ or visit our website: <a href=\"https://travelapp-production-31c0.up.railway.app/\" style=\"color: #0f766e; text-decoration: none; font-weight: bold;\">TravelApp.com</a></p>" +
//                     "    <p style=\"margin: 15px 0 5px 0; font-weight: bold; color: #adb5bd;\">Best regards,</p>" +
//                     "    <p style=\"margin: 0; font-weight: bold; color: #ffffff;\">The TravelApp Team</p>" +
//                     "  </div>" +
//                     "</div>";

//             helper.setText(htmlContent, true);

//             mailSender.send(mimeMessage);
//             System.out.println("📧 Beautiful HTML Booking Email Sent to: " + toEmail);

//         } catch (Exception e) {
//             System.out.println("❌ Failed to send HTML email: " + e.getMessage());
//             e.printStackTrace();
//         }
package com.example.TravelApp.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    // 💡 මෙතනට ඔයා Brevo එකේ Register වුණු ඇත්තම ඊමේල් එක දාන්න (e.g., travel.genie51@gmail.com වගේ එකක් නම් ඒක)
    private final String FROM_EMAIL = "hasinduindusara133@gmail.com";

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    // 🎯 1. Booking Success Email (User හට යන Thank You Message එක)
    @Async
    public void sendBookingSuccessEmail(String toEmail, String userName, String packageName, double price) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

            helper.setFrom(FROM_EMAIL);
            helper.setTo(toEmail);
            helper.setSubject("Booking Confirmed! 🎉 - TravelApp");

            String htmlContent = "<div style=\"background-color: #1a1e21; padding: 30px; font-family: sans-serif; color: #dee2e6; max-width: 600px; margin: 0 auto; border-radius: 8px;\">" +
                    "  <div style=\"background-color: #0f766e; color: #ffffff; padding: 20px; border-radius: 6px 6px 0 0; text-align: center; font-size: 22px; font-weight: bold;\">" +
                    "    ✓ Booking Successful!" +
                    "  </div>" +
                    "  <div style=\"padding: 20px 10px;\">" +
                    "    <p style=\"font-size: 16px; color: #ffffff;\">Hello " + userName + ",</p>" +
                    "    <p style=\"font-size: 14px; line-height: 1.6; color: #adb5bd;\">Thank you for booking with TravelApp! Your adventure has been successfully reserved and your details have been confirmed by our team.</p>" +
                    "  </div>" +
                    "  <div style=\"background-color: #212529; border: 1px solid #2c3034; border-left: 4px solid #0f766e; padding: 20px; border-radius: 4px; margin-bottom: 25px;\">" +
                    "    <h4 style=\"margin-top: 0; color: #0f766e; font-size: 16px; margin-bottom: 12px;\">Your Booking Summary:</h4>" +
                    "    <p style=\"margin: 6px 0; font-size: 14px;\"><strong style=\"color: #ffffff;\">Package:</strong> " + packageName + "</p>" +
                    "    <p style=\"margin: 6px 0; font-size: 14px;\"><strong style=\"color: #ffffff;\">Total Paid:</strong> LKR " + String.format("%,.2f", price) + "</p>" +
                    "    <p style=\"margin: 6px 0; font-size: 14px;\"><strong style=\"color: #ffffff;\">Status:</strong> Confirmed</p>" +
                    "  </div>" +
                    "</div>";

            helper.setText(htmlContent, true);
            mailSender.send(mimeMessage);
            System.out.println("📧 Brevo SMTP: Booking Email Sent to: " + toEmail);
        } catch (Exception e) {
            System.out.println("❌ Brevo SMTP Failed (Booking): " + e.getMessage());
        }
    }

    // 🎯 2. Contact Message Email (User හට සහ සයිට් Owner හට දෙන්නටම යයි)
    @Async
    public void sendContactEmails(String userEmail, String userName, String messageSubject, String messageBody) {
        try {
            // ✉️ A. වෙබ් සයිට් OWNER ට යන Email එක (ඔයාගේ ඊමේල් එකටම එනවා)
            MimeMessage ownerMessage = mailSender.createMimeMessage();
            MimeMessageHelper ownerHelper = new MimeMessageHelper(ownerMessage, "utf-8");
            ownerHelper.setFrom(FROM_EMAIL);
            ownerHelper.setTo(FROM_EMAIL); // 👈 Owner ගේ inbox එකටම එන්න දානවා
            ownerHelper.setSubject("New Contact Inquiry: " + messageSubject);
            
            String ownerHtml = "<div style='background-color:#111; color:#fff; padding:20px; font-family:sans-serif;'>" +
                    "<h2>New Message from Website Contact Form</h2>" +
                    "<p><strong>From:</strong> " + userName + " (" + userEmail + ")</p>" +
                    "<p><strong>Message:</strong></p>" +
                    "<p style='background:#222; padding:10px; border-left:3px solid #0f766e;'>" + messageBody + "</p>" +
                    "</div>";
            ownerHelper.setText(ownerHtml, true);
            mailSender.send(ownerMessage);

            // ✉️ B. මැසේජ් එක දාපු USER ට යන Thank You Email එක
            MimeMessage userMessage = mailSender.createMimeMessage();
            MimeMessageHelper userHelper = new MimeMessageHelper(userMessage, "utf-8");
            userHelper.setFrom(FROM_EMAIL);
            userHelper.setTo(userEmail); // 👈 මැසේජ් එක දාපු කෙනාට යනවා
            userHelper.setSubject("We received your message! 📬 - TravelApp");
            
            String userHtml = "<div style='background-color:#1a1e21; color:#dee2e6; padding:20px; font-family:sans-serif;'>" +
                    "<h3>Hi " + userName + ",</h3>" +
                    "<p>Thank you for contacting TravelApp. We have successfully received your inquiry regarding <b>" + messageSubject + "</b>.</p>" +
                    "<p>Our team will review your message and get back to you within 24 hours.</p>" +
                    "</div>";
            userHelper.setText(userHtml, true);
            mailSender.send(userMessage);

            System.out.println("📧 Brevo SMTP: Contact emails sent to Owner and User!");
        } catch (Exception e) {
            System.out.println("❌ Brevo SMTP Failed (Contact): " + e.getMessage());
        }
    }

    // 🎯 3. Forgot / Reset Password Email
    @Async
    public void sendPasswordResetEmail(String toEmail, String resetLink) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

            helper.setFrom(FROM_EMAIL);
            helper.setTo(toEmail);
            helper.setSubject("Reset Your Password - TravelApp");

            String htmlContent = "<div style='background-color:#1a1e21; color:#dee2e6; padding:30px; font-family:sans-serif; max-width:500px; margin:0 auto; border-radius:8px;'>" +
                    "  <h2 style='color:#0f766e; text-align:center;'>Password Reset Request</h2>" +
                    "  <p>You requested to reset your password. Click the button below to change your password.</p>" +
                    "  <div style='text-align:center; margin:30px 0;'>" +
                    "    <a href='" + resetLink + "' style='background-color:#0f766e; color:#ffffff; padding:12px 25px; text-decoration:none; font-weight:bold; border-radius:4px;'>Reset Password</a>" +
                    "  </div>" +
                    "</div>";

            helper.setText(htmlContent, true);
            mailSender.send(mimeMessage);
            System.out.println("📧 Brevo SMTP: Password reset link sent to: " + toEmail);
        } catch (Exception e) {
            System.out.println("❌ Brevo SMTP Failed (Reset Password): " + e.getMessage());
        }
    }
}
//     }
// }
