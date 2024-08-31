package alexdev.useradmininitializer.adminsetup;

import alexdev.useradmininitializer.user.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class GenerateDefaultAdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateDefaultAdminService.class);

    private final AdminDataSourceConfig dataSourceConfig;
    private final AdminUserSetupService<AppUser> adminSetupService;
    private final PasswordEncoder encoder;

    public GenerateDefaultAdminService(AdminDataSourceConfig dataSourceConfig, AdminUserSetupService<AppUser> adminSetupService, PasswordEncoder encoder) {
        this.dataSourceConfig = dataSourceConfig;
        this.adminSetupService = adminSetupService;
        this.encoder = encoder;
    }

    public void generate() {

        if(!adminSetupService.exists()) {

            LOGGER.info("Generating default administrator user...");

            var username = dataSourceConfig.getUsername();
            var password = dataSourceConfig.getPassword();

            var user = new AppUser();
            user.setId();
            user.setUsername(username);
            user.setPassword(encoder.encode(password));
            user.setRole(AppUser.Role.ADMIN);
            adminSetupService.create(user);

            LOGGER.info("Successfully created the default administrator user. username: {}, password: {}", username, password);
            LOGGER.warn("WARNING: Default admin user created. Change the default credentials immediately!");
        }
    }
}
