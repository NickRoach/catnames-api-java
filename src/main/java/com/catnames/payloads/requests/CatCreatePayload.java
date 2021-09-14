package com.catnames.payloads.requests;

import lombok.Getter;
import lombok.Setter;

public class CatCreatePayload{
    @Getter @Setter
    private String name;

    @Getter @Setter
    private String occupation;

    @Getter
    private Integer id;

    public CatCreatePayload() {};

    public CatCreatePayload(
            String name,
            String occupation
    ){
        this.setName(name);
        this.setOccupation(occupation);
    }
}
