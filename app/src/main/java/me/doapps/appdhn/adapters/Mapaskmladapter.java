package me.doapps.appdhn.adapters;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import me.doapps.appdhn.R;
import me.doapps.appdhn.activities.Mapapoligonos;
import me.doapps.appdhn.activities.MapsActivity;
import me.doapps.appdhn.models.Cartasevacua;
public class Mapaskmladapter extends RecyclerView.Adapter<Mapaskmladapter.MyViewHolder>{

    Context context;
    ArrayList<Cartasevacua> listadozonas;

    public Mapaskmladapter(Context c , ArrayList<Cartasevacua> p) {
        context = c;
        listadozonas = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewtwo, parent, false);
        return new Mapaskmladapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {



        holder.nombre.setText(listadozonas.get(position).getNombre());
        Log.d("DATA LISTADOZONAS", listadozonas.get(position).getUrl_kml1());




        holder.iramapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
            Intent intent = new Intent(holder.itemView.getContext(), MapsActivity.class);
                intent.putExtra("PRIMERA", "SDWDWEDEWD");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivity(intent);

*/

                ((MapsActivity)context).verpopup(listadozonas.get(position).getUrl_kml1());


                /*

*/




/*
                Intent intent = new Intent( holder.itemView.getContext(), MapsActivity.class);
                Bundle b = new Bundle();
                b.putString("PRIMERA", "SDWDWEDEWD");
                intent.putExtras(b);
                holder.itemView.getContext().startActivity(intent);



                Intent intent2 = new Intent(holder.itemView.getContext(), Mapapoligonos.class);
                holder.itemView.getContext().startActivity(intent2);


*/

              //  Toast.makeText(context, position+ listadozonas.get(position).getNombre() +  "wwww", Toast.LENGTH_SHORT).show();


            }
        });

    }

    @Override
    public int getItemCount() {
        return listadozonas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        ImageButton iramapa;

        public MyViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            iramapa = (ImageButton) itemView.findViewById(R.id.iramapa);



        }

        public void onClick(final int position) {
/*
            iramapa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Toast.makeText(context, position+" is clicked", Toast.LENGTH_SHORT).show();
                }
            });
            */

        }

    }

/*
    public void iramapax(){
        Intent intent = new Intent(MapsActivity.this, MapsActivity.class);
        // Intent intent = new Intent(volcanmenu.this,Configuraciones.class);

        startActivity(intent);

    }
    */

}