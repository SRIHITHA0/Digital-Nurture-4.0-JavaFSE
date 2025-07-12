package com.cognizant.spring_learn;

public class Country {
    private String code;
    private String name;

    // Getters and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString() for clean output
    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
