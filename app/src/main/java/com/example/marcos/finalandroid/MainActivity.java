package com.example.marcos.finalandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.marcos.finalandroid.DatosApiService.DatosOpenApiService;
import com.example.marcos.finalandroid.models.Solucion;
import com.example.marcos.finalandroid.models.SolucionRespuesta;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private Button acerca;
    private RecyclerView recyclerView;
    private ListaAdapter listaAdapter;
    private int offset;
    private boolean aptoParaCargar;
    private static final String TAG = "OpenData";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listaAdapter = new ListaAdapter(this);
        //progressBar = (ProgressBar) findViewById(R.id.progressBar);
        recyclerView.setAdapter(listaAdapter);
        acerca = (Button) findViewById(R.id.acercaDe);
        acerca.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), AcercaDe.class);
                startActivityForResult(intent, 0);
            }
        });

        //recyclerView.setAdapter(listaHabilidadAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (aptoParaCargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, " Llegamos al final.");

                            aptoParaCargar = false;
                            offset += 20;
                            obtenerDatosSoluciones();

                        }
                    }
                }
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //aptoParaCargar = true;
        //offset = 0;
        obtenerDatosSoluciones();
    }

    private void acercaDe(View view) {
        Intent intent = new Intent( getApplicationContext(), AcercaDe.class );
    }

    private void obtenerDatosSoluciones() {
        DatosOpenApiService service = retrofit.create(DatosOpenApiService.class);
        Call<List<Solucion>> solucionRespuestaCall = service.obtenerListaSoluciones();

        solucionRespuestaCall.enqueue(new Callback<List<Solucion>>() {
            @Override
            public void onResponse(Call<List<Solucion>> call, Response<List<Solucion>> response) {
                if(response.isSuccessful()){
                    List lista = response.body();
                    listaAdapter.adicionarLista(lista);


                    for(int i=0;i<lista.size();i++)
                    {
                        Solucion p = (Solucion)lista.get(i);
                        Log.i(TAG," Nombre: "+p.getNombreDeLaSoluciN()+" Datos usados: "+p.getDatosAbiertosUtilizados());
                    }

                }else
                {
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Solucion>> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });
    }
}
