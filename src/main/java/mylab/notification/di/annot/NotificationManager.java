package mylab.notification.di.annot;

public class NotificationManager {
    private NotificationService emailService;
    private NotificationService smsService;

    // 생성자를 통해 인터페이스 타입의 서비스들을 주입받습니다. [cite: 99]
    public NotificationManager(NotificationService emailService, NotificationService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public NotificationService getEmailService() { return emailService; }
    public NotificationService getSmsService() { return smsService; }

    // 각각의 서비스를 사용하여 알림을 전송합니다. [cite: 100]
    public void sendNotificationByEmail(String message) {
        emailService.sendNotification(message);
    }

    public void sendNotificationBySms(String message) {
        smsService.sendNotification(message);
    }
}