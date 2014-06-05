
package com.example.lifesum.model;

import java.util.ArrayList;
import com.google.gson.annotations.Expose;

public class Response {

    @Expose
    private java.util.List<com.example.lifesum.model.Food> list = new ArrayList<com.example.lifesum.model.Food>();

    public java.util.List<com.example.lifesum.model.Food> getList() {
        return list;
    }

    public void setList(java.util.List<com.example.lifesum.model.Food> list) {
        this.list = list;
    }

    public Response withList(java.util.List<com.example.lifesum.model.Food> list) {
        this.list = list;
        return this;
    }

}
