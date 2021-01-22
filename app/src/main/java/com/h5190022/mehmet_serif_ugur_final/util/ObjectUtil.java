package com.h5190022.mehmet_serif_ugur_final.util;

import com.google.gson.Gson;
import com.h5190022.mehmet_serif_ugur_final.model.PlaystationModel;

public class ObjectUtil {

    public  static String konsolToJsonString(PlaystationModel PlaystationModel)
    {
        Gson gson = new Gson();
        return   gson.toJson(PlaystationModel);
    }

    public  static PlaystationModel jsonStringTokonsol(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,PlaystationModel.class);
    }
}
