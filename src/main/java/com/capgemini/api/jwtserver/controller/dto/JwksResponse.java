package com.capgemini.api.jwtserver.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class JwksResponse {

    private List keys;


    public JwksResponse(){
        keys = new ArrayList();
    }

    public List getKeys() {
        return keys;
    }

    public void setKeys(List keys) {
        this.keys = keys;
    }
}
