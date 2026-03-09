package mylab.notification.di.annot;

public interface NotificationService {
    // 알림을 보내는 기능에 대한 규격만 정의합니다. 
    void sendNotification(String message);
}