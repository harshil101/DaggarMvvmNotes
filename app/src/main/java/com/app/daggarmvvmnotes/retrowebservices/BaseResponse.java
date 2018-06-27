package com.app.daggarmvvmnotes.retrowebservices;


//Here I suppose base response will look like this
public class BaseResponse {
    String status,message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
