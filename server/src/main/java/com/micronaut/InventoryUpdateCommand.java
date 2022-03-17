package com.micronaut;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class InventoryUpdateCommand {
    @NotNull
    private final Long id;

    @NotBlank
    private final String name;

    public InventoryUpdateCommand(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
