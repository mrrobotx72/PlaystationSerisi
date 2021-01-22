package com.h5190022.mehmet_serif_ugur_final.network;

import com.h5190022.mehmet_serif_ugur_final.model.PlaystationModel;

import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    //base url
    //
    @GET("PlaystationApi.json.txt")
    Observable<List<PlaystationModel>> konsollariGetir();
}
