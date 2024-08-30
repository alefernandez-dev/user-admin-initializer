package alexdev.useradmininitializer.security;

import alexdev.useradmininitializer.user.AppUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public final class UserDetailsMapper {
  static UserDetails toUserDetails(AppUser user) {
      return User.builder()
              .username(user.getUsername())
              .password(user.getPassword())
              .roles(user.getRole().name())
              .build();
  }
}
