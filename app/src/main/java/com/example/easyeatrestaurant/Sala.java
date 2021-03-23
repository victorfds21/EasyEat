package com.example.easyeatrestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.example.easyeatrestaurant.Adapter.SalaAdapter;
import com.example.easyeatrestaurant.Clases.Comanda;

import java.util.ArrayList;

public class Sala extends AppCompatActivity {


        private RecyclerView recyclerView;
        private SalaAdapter adapter;
        private RecyclerView.LayoutManager manager;
        private int i=0;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sala);

            recyclerView = (RecyclerView) findViewById(R.id.reycleSala);
            //manager=new LinearLayoutManager(this);
            manager = new GridLayoutManager(this, 3
            );
            recyclerView.setLayoutManager(manager);

            adapter = new SalaAdapter(this, listaSala());

            adapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    i++;
                    Handler handler = new Handler();
                    Runnable run = new Runnable() {
                        @Override
                        public void run() {
                            i=0;
                        }
                    };
                    if(i==1){
                        Toast.makeText(getApplication(),"Click...",Toast.LENGTH_SHORT).show();
                        handler.postDelayed(run, 400);

                    }else if(i==2){

                        Toast.makeText(getApplicationContext(),"Double Click",Toast.LENGTH_SHORT).show();
                        i=0;
                    }

                }
            });
            recyclerView.setAdapter(adapter);



        }

        private ArrayList<Comanda> listaSala() {
            ArrayList<Comanda> lista = new ArrayList<>();
            lista.add(new Comanda("M01", "Coca cola", "Agua", "Vino tinto"));
            lista.add(new Comanda("M02", "Agua", "Cerveza"));
            lista.add(new Comanda("M03", "Vino rosado", "Nestea"));
            lista.add(new Comanda("M04", "Agua"));



            return lista;
        }
    }