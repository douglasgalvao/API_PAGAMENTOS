package com.Payment_API.config;
import com.Payment_API.Dtos.UserBankDTO;
import com.Payment_API.entities.user.UserBank;
import com.Payment_API.mapper.UserBankMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import lombok.Data;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
@Data
public class DecodeJWT {
    public String sub;
    public String name;
    public Boolean admin;

    public static DecodeJWT getDecoded(String encodedToken) throws UnsupportedEncodingException {
        String[] pieces = encodedToken.split("\\.");
        String b64payload = pieces[1];
        String jsonString = new String(Base64.decodeBase64(b64payload), "UTF-8");
        return new Gson().fromJson(jsonString, DecodeJWT.class);
    }

    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

}