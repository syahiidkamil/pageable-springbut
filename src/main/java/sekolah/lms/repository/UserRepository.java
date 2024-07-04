package sekolah.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sekolah.lms.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}