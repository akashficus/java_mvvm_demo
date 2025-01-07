package com.rf.javamvvmdemo.ui.base;

import com.google.gson.*;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class BaseResponseModel2Deserializer<P> implements JsonDeserializer<BaseResponseModel2<P>> {

    @Override
    public BaseResponseModel2<P> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        // Extract fields
        JsonElement dataElement = jsonObject.get("data");
        JsonElement statusElement = jsonObject.get("status");
        JsonElement messageElement = jsonObject.get("message");

        // Get the parameterized type of `P`
        Type dataType = ((ParameterizedType) typeOfT).getActualTypeArguments()[0];

        // Deserialize `data` as List<P>
        List<P> data = context.deserialize(dataElement, TypeToken.getParameterized(List.class, dataType).getType());

        // Return a concrete implementation
        return new ConcreteResponseModel<>(data,
                statusElement != null ? Integer.parseInt(statusElement.getAsString()) : null,
                messageElement != null ? messageElement.getAsString() : null);
    }
}


