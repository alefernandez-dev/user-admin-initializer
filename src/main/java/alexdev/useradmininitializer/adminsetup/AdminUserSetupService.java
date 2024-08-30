package alexdev.useradmininitializer.adminsetup;

public interface AdminUserSetupService<T> {
    boolean exists();
    void create(T t);
}
