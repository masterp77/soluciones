package com.example.marcos.finalandroid.DatosApiService;

import com.example.marcos.finalandroid.models.Solucion;
import com.example.marcos.finalandroid.models.SolucionRespuesta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Karol on 1/06/2017.
 */

public interface DatosOpenApiService {
    @GET("mhp8-35wy.json")
    Call<List<Solucion>> obtenerListaSoluciones();
}
