package alexdev.useradmininitializer.adminsetup;

public interface DefaultUserAdminSetupService<T> {
    boolean exists();
    void create(T t);
}
