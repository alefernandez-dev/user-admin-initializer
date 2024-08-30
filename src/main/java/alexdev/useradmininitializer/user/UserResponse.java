package alexdev.useradmininitializer.user;

import java.io.Serializable;
import java.util.UUID;

public record UserResponse(UUID id, String username, String role) implements Serializable {
}
