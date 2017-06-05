package com.example.marcos.finalandroid.models;

import java.util.ArrayList;

/**
 * Created by Karol on 4/06/2017.
 */

public class SolucionRespuesta {
    private ArrayList<Solucion> results;
    private Solucion result;

    public Solucion getResult() {
        return result;
    }

    public void setResult(Solucion result) {
        this.result = result;
    }

    public ArrayList<Solucion> getResults() {
        return results;
    }

    public void setResults(ArrayList<Solucion> results) {
        this.results = results;
    }
}
