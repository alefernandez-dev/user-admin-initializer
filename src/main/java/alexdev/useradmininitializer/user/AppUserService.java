package alexdev.useradmininitializer.user;

import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppUserService {

    private final AppUserJpaRepository repository;
    private final PasswordEncoder encoder;

    public AppUserService(AppUserJpaRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }


    void create(AppUser user) {

        if (repository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("error");
        }

        user.setPassword(encoder.encode(user.getPassword()));

        repository.save(user);

    }

    List<AppUser> list(int limit) {
        return repository
                .findAll(PageRequest.of(0, limit))
                .toList();
    }

    void deleteById(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("error");
        }
        repository.deleteById(id);
    }

}
