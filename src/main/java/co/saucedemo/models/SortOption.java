package co.saucedemo.models;

import java.util.Arrays;

public enum SortOption {
    NAME_A_TO_Z("Name (A to Z)"),
    NAME_Z_TO_A("Name (Z to A)"),
    PRICE_LOW_TO_HIGH("Price (low to high)"),
    PRICE_HIGH_TO_LOW("Price (high to low)");

    private final String label;

    SortOption(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }

    public static SortOption fromLabel(String label) {
        return Arrays.stream(values())
                .filter(option -> option.label.equals(label))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown sort option: " + label));
    }
}