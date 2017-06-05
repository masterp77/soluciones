package com.example.marcos.finalandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Karol on 1/06/2017.
 */

public class Solucion {
    @SerializedName("conectada_al_portal_de_datos_abiertos")
    @Expose
    private String conectadaAlPortalDeDatosAbiertos;
    @SerializedName("datos_abiertos_utilizados")
    @Expose
    private String datosAbiertosUtilizados;
    @SerializedName("desarrollador")
    @Expose
    private String desarrollador;
    @SerializedName("descripci_n")
    @Expose
    private String descripciN;
    @SerializedName("enlace_para_android")
    @Expose
    private String enlaceParaAndroid;
    @SerializedName("enlace_para_ios")
    @Expose
    private String enlaceParaIos;
    @SerializedName("nombre_de_la_soluci_n")
    @Expose
    private String nombreDeLaSoluciN;
    @SerializedName("tipo_de_aplicaci_n")
    @Expose
    private String tipoDeAplicaciN;

    public String getConectadaAlPortalDeDatosAbiertos() {
        return conectadaAlPortalDeDatosAbiertos;
    }

    public void setConectadaAlPortalDeDatosAbiertos(String conectadaAlPortalDeDatosAbiertos) {
        this.conectadaAlPortalDeDatosAbiertos = conectadaAlPortalDeDatosAbiertos;
    }

    public String getDatosAbiertosUtilizados() {
        return datosAbiertosUtilizados;
    }

    public void setDatosAbiertosUtilizados(String datosAbiertosUtilizados) {
        this.datosAbiertosUtilizados = datosAbiertosUtilizados;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public String getDescripciN() {
        return descripciN;
    }

    public void setDescripciN(String descripciN) {
        this.descripciN = descripciN;
    }

    public String getEnlaceParaAndroid() {
        return enlaceParaAndroid;
    }

    public void setEnlaceParaAndroid(String enlaceParaAndroid) {
        this.enlaceParaAndroid = enlaceParaAndroid;
    }

    public String getEnlaceParaIos() {
        return enlaceParaIos;
    }

    public void setEnlaceParaIos(String enlaceParaIos) {
        this.enlaceParaIos = enlaceParaIos;
    }

    public String getNombreDeLaSoluciN() {
        return nombreDeLaSoluciN;
    }

    public void setNombreDeLaSoluciN(String nombreDeLaSoluciN) {
        this.nombreDeLaSoluciN = nombreDeLaSoluciN;
    }

    public String getTipoDeAplicaciN() {
        return tipoDeAplicaciN;
    }

    public void setTipoDeAplicaciN(String tipoDeAplicaciN) {
        this.tipoDeAplicaciN = tipoDeAplicaciN;
    }

}
