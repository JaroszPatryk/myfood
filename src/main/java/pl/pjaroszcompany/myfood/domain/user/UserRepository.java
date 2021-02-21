package pl.pjaroszcompany.myfood.domain.user;


import java.util.Optional;

public interface UserRepository {
    void create(User user);

    Optional<User> findByUsername(String username);
}
