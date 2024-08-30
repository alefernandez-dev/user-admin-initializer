package alexdev.useradmininitializer.user;

import java.io.Serializable;

public record UserRequest(String username, String password, String role) implements Serializable {
}
