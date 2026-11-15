package co.saucedemo.utils;

public class Delay {

    private static final String PROPERTY = "delay.ms";

    private Delay() {}

    public static void pause() {
        long milliseconds = Long.getLong(PROPERTY, 0L);
        if (milliseconds <= 0) {
            return;
        }
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}