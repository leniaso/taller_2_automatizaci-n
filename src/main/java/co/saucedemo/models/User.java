package co.saucedemo.models;

public record User(String username, String password) {

    private static final String PUBLIC_PASSWORD = "secret_sauce";

    public static User standard() {
        return new User("standard_user", PUBLIC_PASSWORD);
    }

    public static User lockedOut() {
        return new User("locked_out_user", PUBLIC_PASSWORD);
    }

    public static User problem() {
        return new User("problem_user", PUBLIC_PASSWORD);
    }

    public static User performanceGlitch() {
        return new User("performance_glitch_user", PUBLIC_PASSWORD);
    }

    public static User with(String username, String password) {
        return new User(username, password);
    }

    public static User withPublicPassword(String username) {
        return new User(username, PUBLIC_PASSWORD);
    }
}