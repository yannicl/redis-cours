package com.yannicl;

import java.io.Serializable;

public class UserProfile implements Serializable {

    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
