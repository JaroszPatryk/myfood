package pl.pjaroszcompany.myfood.external.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.pjaroszcompany.myfood.domain.user.User;
import pl.pjaroszcompany.myfood.domain.user.UserRepository;

@Component
@RequiredArgsConstructor
public class DatabaseUserRepository implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    @Override
    public void create(User user) {
        UserEntity entity = UserEntity.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
        jpaUserRepository.save(entity);
    }
}
