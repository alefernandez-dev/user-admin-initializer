package alexdev.useradmininitializer.adminsetup;

import alexdev.useradmininitializer.user.AppUser;
import alexdev.useradmininitializer.user.AppUserJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminAppUserSetupServiceImpl implements AdminUserSetupService<AppUser> {

    private final AppUserJpaRepository repository;

    public AdminAppUserSetupServiceImpl(AppUserJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean exists() {
        return repository.existsByRole(AppUser.Role.ADMIN);
    }

    @Override
    public void create(AppUser user) {
        repository.save(user);
    }
}
