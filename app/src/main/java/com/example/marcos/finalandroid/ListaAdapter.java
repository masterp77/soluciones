package com.example.marcos.finalandroid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.marcos.finalandroid.DatosApiService.DatosOpenApiService;
import com.example.marcos.finalandroid.models.Solucion;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Karol on 4/06/2017.
 */

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ViewHolder>{


    private List<Solucion> dataset;
    private Context context;
    private static final String TAG="Soluciones";
    private Retrofit retrofit;
    public String habilidades="";

    ProgressBar progressBar;



    String id = "";

    public ListaAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        //for (int i=0;i<dataset.size();i++){
        final Solucion s = dataset.get(position);
        //String var = s.getNombreDeLaSoluciN();
        holder.nombreTextView.setText(s.getNombreDeLaSoluciN());
        holder.tvDes.setText(s.getDesarrollador());
        holder.tvDatos.setText(s.getDatosAbiertosUtilizados());
        holder.tvTipo.setText(s.getTipoDeAplicaciN());
        holder.tvDesc.setText(s.getDescripciN());
        //String heightq = s.getTipoDeAplicaciN();
        //}
        progressBar.setVisibility(View.GONE);
        holder.ivAndroid.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                final Solucion s = dataset.get(position);
                Uri uri = Uri.parse(s.getEnlaceParaAndroid());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);


            }
        });

        holder.ivIOS.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                final Solucion s = dataset.get(position);
                Uri uri = Uri.parse(s.getEnlaceParaIos());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent);


            }
        });

        
    }


    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarLista(List<Solucion> listaSolucion) {
        dataset.addAll(listaSolucion);
        notifyDataSetChanged();
        //progressBar.setVisibility(View.GONE);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nombreTextView,tvDes,tvDatos,tvTipo,tvDesc;
        private ImageView ivAndroid,ivIOS;

        public ViewHolder(View itemView) {
            super(itemView);


            nombreTextView = (TextView) itemView.findViewById(R.id.nombreTextView);
            tvDes = (TextView) itemView.findViewById(R.id.tvDes);
            tvDatos = (TextView) itemView.findViewById(R.id.tvDatos);
            tvTipo = (TextView) itemView.findViewById(R.id.tvTipo);
            tvDesc = (TextView) itemView.findViewById(R.id.tvDesc);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
            ivAndroid = (ImageView) itemView.findViewById(R.id.ivAndroid);
            ivIOS = (ImageView) itemView.findViewById(R.id.ivIOS);



  /*          itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();

                    final Solucion s = dataset.get(position);

                    Intent intent = new Intent( context, Main2Activity.class );
                    intent.putExtra( "idP",s.getNombreDeLaSoluciN());
                    context.startActivity(intent);
                    Snackbar.make(v, "Click detected on item " + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();


                }
            });
*/
        }
    }

}
