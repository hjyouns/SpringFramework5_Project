package mylab.spring.di.annot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository // [cite: 63, 65]
public class UserRepository {
    @Value("MySQL") // 속성에 직접 값을 주입 [cite: 75]
    private String dbType;

    public UserRepository() {}

    public String getDbType() { return dbType; }
    public void setDbType(String dbType) { this.dbType = dbType; }

    public boolean saveUser(String userId, String name) {
        System.out.println("사용자 저장: " + userId + ", " + name + " (DB: " + dbType + ")");
        return true;
    }

    @Override
    public String toString() {
        return "UserRepository [dbType=" + dbType + "]";
    }
}