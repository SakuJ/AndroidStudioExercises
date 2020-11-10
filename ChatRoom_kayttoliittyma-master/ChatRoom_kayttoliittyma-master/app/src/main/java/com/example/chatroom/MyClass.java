package com.example.chatroom;

import java.io.Serializable;

public class MyClass implements Serializable {

    private String message;
    private String kayttaja;

    public MyClass(String message, String kayttaja){
        this.message = message;
        this.kayttaja = kayttaja;
    }

    public void setMessage(){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setKayttaja(){
        this.kayttaja = kayttaja;
    }

    public String getKayttaja(){
        return kayttaja;
    }
}