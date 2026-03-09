package mylab.spring.di.annot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // [cite: 63, 65]
public class UserService {
    @Autowired // UserRepository 자동 주입 [cite: 56, 63]
    private UserRepository userRepository;

    @Autowired // SecurityService 자동 주입 [cite: 56, 63]
    private SecurityService securityService;

    public UserRepository getUserRepository() { return userRepository; }
    public SecurityService getSecurityService() { return securityService; }

    public boolean registerUser(String userId, String name, String password) {
        // SecurityService로 인증 후 UserRepository에 저장 [cite: 57]
        if (securityService.authenticate(userId, password)) {
            return userRepository.saveUser(userId, name);
        }
        return false;
    }
}