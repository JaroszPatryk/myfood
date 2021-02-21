package pl.pjaroszcompany.myfood.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    public final UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;


    public void register(User user) {
        user.encodePassword(passwordEncoder);
        userRepository.create(user);
    }
}
