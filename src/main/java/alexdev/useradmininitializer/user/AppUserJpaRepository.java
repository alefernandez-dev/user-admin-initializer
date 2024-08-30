package alexdev.useradmininitializer.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AppUserJpaRepository extends JpaRepository<AppUser, UUID> {
    boolean existsByRole(AppUser.Role role);
    boolean existsByUsername(String username);
    Optional<AppUser> findByUsername(String username);
}
