package pl.pjaroszcompany.myfood.external.user;


import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {


}
