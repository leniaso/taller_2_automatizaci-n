package co.saucedemo.models;

public record Product(String name) {

    public static Product named(String name) {
        return new Product(name);
    }
}