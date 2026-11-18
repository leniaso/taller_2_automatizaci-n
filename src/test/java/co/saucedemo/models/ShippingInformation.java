package co.saucedemo.models;

/** Shipping data for checkout step one. Keeps the test data out of the steps. */
public record ShippingInformation(String firstName, String lastName, String postalCode) {

    public static ShippingInformation valid() {
        return new ShippingInformation("Ana", "Gomez", "050001");
    }

    /** Maps the case name written in the Gherkin to a data set. */
    public static ShippingInformation forCase(String caseName) {
        return switch (caseName.trim().toLowerCase()) {
            case "valid data" -> valid();
            case "missing first name" -> new ShippingInformation("", "Gomez", "050001");
            case "missing last name" -> new ShippingInformation("Ana", "", "050001");
            case "missing postal code" -> new ShippingInformation("Ana", "Gomez", "");
            case "no data" -> new ShippingInformation("", "", "");
            default -> throw new IllegalArgumentException("Unknown shipping data case: " + caseName);
        };
    }
}
