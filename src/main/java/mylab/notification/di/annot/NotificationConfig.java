package mylab.notification.di.annot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Spring 설정 클래스임을 명시합니다. [cite: 102]
public class NotificationConfig {

    @Bean // 이메일 서비스 빈 등록 [cite: 103, 104]
    public NotificationService emailService() {
        return new EmailNotificationService("smtp.gmail.com", 587);
    }

    @Bean // SMS 서비스 빈 등록 [cite: 103, 105]
    public NotificationService smsService() {
        return new SmsNotificationService("SKT");
    }

    @Bean // 매니저 빈 등록 및 위에서 만든 서비스들을 주입 [cite: 103, 106]
    public NotificationManager notificationManager() {
        return new NotificationManager(emailService(), smsService());
    }
}