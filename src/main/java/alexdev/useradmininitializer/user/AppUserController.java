package alexdev.useradmininitializer.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class AppUserController {

    private final AppUserService service;

    public AppUserController(AppUserService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<UserResponse>> list(@RequestParam(required = false, defaultValue = "10") int limit) {
        var users = service.list(limit).stream().map(AppUserMapper::toUserResponse).toList();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    ResponseEntity<Message> create(@RequestBody UserRequest request) {
        service.create(AppUserMapper.toAppUser(request));
        return ResponseEntity.ok(new Message("user created successfully"));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Message> delete(@PathVariable UUID id) {
        service.deleteById(id);
        return ResponseEntity.ok(new Message("user deleted successfully"));
    }

    private record Message(String message) implements Serializable {}

}
