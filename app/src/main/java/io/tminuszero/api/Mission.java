package io.tminuszero.api;

public class Mission {

    private String name;
    private String description;
    private String type;

    Mission() {
        name = "";
        description = "";
        type = "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

}