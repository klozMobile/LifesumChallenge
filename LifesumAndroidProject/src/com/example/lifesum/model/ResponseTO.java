
package com.example.lifesum.model;

import com.google.gson.annotations.Expose;

public class ResponseTO {

    @Expose
    private Meta meta;
    @Expose
    private Response response;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public ResponseTO withMeta(Meta meta) {
        this.meta = meta;
        return this;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public ResponseTO withResponse(Response response) {
        this.response = response;
        return this;
    }

}
