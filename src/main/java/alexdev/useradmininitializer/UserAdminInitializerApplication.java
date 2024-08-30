package alexdev.useradmininitializer;

import alexdev.useradmininitializer.adminsetup.GenerateDefaultAdminService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserAdminInitializerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAdminInitializerApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(GenerateDefaultAdminService generateDefaultUserAdminService) {
		return args -> generateDefaultUserAdminService.generate();
	}

}
