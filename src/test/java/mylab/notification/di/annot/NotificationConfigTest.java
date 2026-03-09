package mylab.notification.di.annot;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class) // 자바 설정을 불러옵니다. [cite: 108]
public class NotificationConfigTest {

    @Autowired
    private NotificationManager notificationManager; // 매니저 주입 [cite: 118]

    @Test
    public void testNotificationManager() {
        // 1. 매니저가 정상적으로 생성(주입)되었는지 검증 [cite: 109, 119]
        assertNotNull(notificationManager);

        // 2. 이메일 서비스 주입 및 설정값 검증 [cite: 110, 120, 121, 122, 123]
        EmailNotificationService emailService = (EmailNotificationService) notificationManager.getEmailService();
        assertNotNull(emailService);
        assertEquals("smtp.gmail.com", emailService.getSmtpServer());
        assertEquals(587, emailService.getPort());

        // 3. SMS 서비스 주입 및 설정값 검증 [cite: 110, 126, 127]
        SmsNotificationService smsService = (SmsNotificationService) notificationManager.getSmsService();
        assertNotNull(smsService);
        assertEquals("SKT", smsService.getProvider());

        // 4. 메서드 실행 테스트 [cite: 111, 128, 129, 130]
        notificationManager.sendNotificationByEmail("테스트 이메일");
        notificationManager.sendNotificationBySms("테스트 SMS");
    }
}