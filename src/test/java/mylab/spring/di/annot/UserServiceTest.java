package mylab.spring.di.annot;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml") // [cite: 66, 71]
public class UserServiceTest {

    @Autowired
    private UserService userService; // [cite: 72]

    @Test
    public void testUserService() {
        // 1. UserService 주입 검증 [cite: 73]
        assertNotNull(userService, "UserService는 null이 아니어야 합니다.");

        // 2. UserRepository 주입 및 속성 검증 [cite: 74, 75]
        assertNotNull(userService.getUserRepository());
        assertEquals("MySQL", userService.getUserRepository().getDbType());

        // 3. SecurityService 주입 검증 [cite: 76]
        assertNotNull(userService.getSecurityService());

        // 4. 회원가입 기능 검증 [cite: 77]
        boolean isRegistered = userService.registerUser("user01", "홍길동", "password123");
        assertTrue(isRegistered);
    }
}