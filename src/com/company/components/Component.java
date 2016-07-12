package com.company.components;

/**
 * Created by Stela on 10-Jul-16.
 */
public abstract class Component {
    private String name;
    private String type;

    public Component(String name, String type) {
        this.setName(name);
        this.setType(type);
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    protected void setType(String type) {
        this.type = type;
    }
}
