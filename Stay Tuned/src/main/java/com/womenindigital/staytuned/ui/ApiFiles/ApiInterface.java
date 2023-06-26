package com.womenindigital.staytuned.ui.ApiFiles;

import com.womenindigital.staytuned.Model.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("http://dynamichubscom.ipage.com/wid_bongobondhu/getPhoto.php")
    abstract Call<List<Photo>> getPhoto(
            @Query("item_type") String item_type,
            @Query("key") String keyword
    );
}
