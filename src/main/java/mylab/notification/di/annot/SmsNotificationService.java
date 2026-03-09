package mylab.notification.di.annot;

public class SmsNotificationService implements NotificationService {
    private String provider;

    // 생성자를 통해 제공업체(통신사) 정보를 주입받습니다. [cite: 95]
    public SmsNotificationService(String provider) {
        this.provider = provider;
    }

    public String getProvider() { return provider; }

    @Override
    public void sendNotification(String message) {
        // 메시지와 함께 제공업체 정보를 출력합니다. [cite: 96]
        System.out.println("SMS 알림 전송: " + message + " (제공업체: " + provider + ")");
    }
}