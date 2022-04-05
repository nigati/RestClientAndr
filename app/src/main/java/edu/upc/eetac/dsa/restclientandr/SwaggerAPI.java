package edu.upc.eetac.dsa.restclientandr;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SwaggerAPI {
    @GET("tracks")
    Call<List<Track>> loadTracks();
    @POST("tracks")
    Call<Track> postTrack(@Body Track track);
    @DELETE("tracks/{id}")
    Call<Track> deleteTrack(@Path("id") String id);
}