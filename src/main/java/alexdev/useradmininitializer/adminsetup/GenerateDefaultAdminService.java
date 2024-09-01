package alexdev.useradmininitializer.adminsetup;

import alexdev.useradmininitializer.user.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class GenerateDefaultAdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateDefaultAdminService.class);

    private final DefaultUserAdminDataReader defaultUserAdminDataReader;
    private final DefaultUserAdminSetupService<AppUser> defaultUserAdminSetupService;
    private final PasswordEncoder encoder;

    public GenerateDefaultAdminService(DefaultUserAdminDataReader defaultUserAdminDataReader,
                                       DefaultUserAdminSetupService<AppUser> defaultUserAdminSetupService,
                                       PasswordEncoder encoder) {
        this.defaultUserAdminDataReader = defaultUserAdminDataReader;
        this.defaultUserAdminSetupService = defaultUserAdminSetupService;
        this.encoder = encoder;
    }

    public void generate() {

        if(!defaultUserAdminSetupService.exists()) {

            LOGGER.info("Generating default administrator user...");

            var username = defaultUserAdminDataReader.getUsername();
            var password = defaultUserAdminDataReader.getPassword();

            var user = new AppUser();
            user.setId();
            user.setUsername(username);
            user.setPassword(encoder.encode(password));
            user.setRole(AppUser.Role.ADMIN);
            defaultUserAdminSetupService.create(user);

            LOGGER.info("Successfully created the default administrator user. username: {}, password: {}", username, password);
            LOGGER.warn("WARNING: Default admin user created. Change the default credentials immediately!");
        }
    }
}
