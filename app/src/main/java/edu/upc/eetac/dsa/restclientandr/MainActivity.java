package edu.upc.eetac.dsa.restclientandr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    static final String BASE_URL = "http://10.0.2.2:8080/dsaApp/";
    public void start(){
        /*Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        SwaggerAPI swaggerAPI = retrofit.create(SwaggerAPI.class);
        List<String> input = new ArrayList<>();
        Call<List<Track>> call = swaggerAPI.loadTracks();
        call.enqueue(new Callback<List<Track>>() {
            @Override
            public void onResponse(Call<List<Track>> call, Response<List<Track>> response) {
                if(response.isSuccessful()) {
                    List<Track> TrackList = response.body();
                    TrackList.forEach(track -> input.add(track.getTitle()));
                    mAdapter = new AdapterDatos(input);
                } else {
                    System.out.println(response.errorBody());
                }
            }
            @Override
            public void onFailure(Call<List<Track>> call, Throwable t) {
                t.printStackTrace();
            }
        }); */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        SwaggerAPI swaggerAPI = retrofit.create(SwaggerAPI.class);
        List<String> input = new ArrayList<>();
        Call<List<Track>> call = swaggerAPI.loadTracks();
        call.enqueue(new Callback<List<Track>>() {
            @Override
            public void onResponse(Call<List<Track>> call, Response<List<Track>> response) {
                if(response.isSuccessful()) {
                    List<Track> TrackList = response.body();
                    TrackList.forEach(track -> input.add(track.getTitle()));
                    mAdapter = new AdapterDatos(input);
                    recyclerView.setAdapter(mAdapter);
                } else {
                    System.out.println(response.errorBody());
                }
            }
            @Override
            public void onFailure(Call<List<Track>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}