package com.example.retrofit_.config;

import com.example.retrofit_.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("todos")
    Call<List<Post>> getPosts();
}
