package com.cloudcenturion.springdemo.domain;

public class RestBCrypt {
    private final String passwd;
    private final String encoded;

    public RestBCrypt(String passwd, String encoded) {
        this.passwd = passwd;
        this.encoded = encoded;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getEncoded() {
        return encoded;
    }
}
