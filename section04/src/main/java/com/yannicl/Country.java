package com.yannicl;

public enum Country {
    CANADA,
    OTHER;

    public static Country fromString(String value) {
        for (Country country: Country.values()) {
            if (country.name().equalsIgnoreCase(value)) {
                return country;
            }
        }
        return Country.OTHER;
    }
}
