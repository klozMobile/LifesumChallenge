
package com.example.lifesum.model;

import com.google.gson.annotations.Expose;

public class Meta {

    @Expose
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Meta withCode(int code) {
        this.code = code;
        return this;
    }

}
