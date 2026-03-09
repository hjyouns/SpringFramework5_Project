package mylab.notification.di.annot;

public class EmailNotificationService implements NotificationService {
    private String smtpServer;
    private int port;

    // 생성자를 통해 서버 주소와 포트 번호를 주입받습니다. [cite: 90]
    public EmailNotificationService(String smtpServer, int port) {
        this.smtpServer = smtpServer;
        this.port = port;
    }

    public String getSmtpServer() { return smtpServer; }
    public int getPort() { return port; }

    @Override
    public void sendNotification(String message) {
        // 메시지와 함께 SMTP 서버 정보를 출력합니다. [cite: 91]
        System.out.println("이메일 알림 전송: " + message + " (서버: " + smtpServer + ":" + port + ")");
    }
}