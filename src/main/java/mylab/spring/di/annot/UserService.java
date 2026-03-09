package mylab.spring.di.annot;
@Repository // 데이터 접근 계층임을 명시 (컴포넌트 스캔 대상)
public class UserRepository {
    @Value("MySQL") // 속성에 직접 값을 주입
    private String dbType;
    // ... 기존 코드 (Getter/Setter/saveUser)
}