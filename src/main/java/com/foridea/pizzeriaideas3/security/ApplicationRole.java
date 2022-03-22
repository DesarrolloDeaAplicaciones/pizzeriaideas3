package com.foridea.pizzeriaideas3.security;

public enum ApplicationRole {

    USER("USER"),
    ADMIN("ADMIN"),
    KITCHEN("KITCHEN");

    private static final String ROLE_PREFIX = "ROLE_";
    private final String name;

    ApplicationRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getFullRoleName() {
        return ROLE_PREFIX + name;
    }
}
