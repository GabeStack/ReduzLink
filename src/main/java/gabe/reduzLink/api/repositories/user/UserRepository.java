package gabe.reduzLink.api.repositories.user;

import gabe.reduzLink.api.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
