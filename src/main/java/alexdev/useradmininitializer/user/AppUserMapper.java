package alexdev.useradmininitializer.user;

public final class AppUserMapper {

    static UserResponse toUserResponse(AppUser appUser) {
        return new UserResponse(appUser.getId(), appUser.getUsername(), appUser.getRole().name());
    }

    static AppUser toAppUser(UserRequest request) {

        var user = new AppUser();
        user.setId();
        user.setUsername(request.username());
        user.setPassword(request.password());
        user.setRole(AppUser.Role.valueOf(request.role()));

        return user;
    }

}
