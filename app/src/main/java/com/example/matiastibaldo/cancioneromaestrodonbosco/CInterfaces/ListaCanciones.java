package com.example.matiastibaldo.cancioneromaestrodonbosco.CInterfaces;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.matiastibaldo.cancioneromaestrodonbosco.CDatos.ListaCancioncionesDB;
import com.example.matiastibaldo.cancioneromaestrodonbosco.CEntidades.Cancion;
import com.example.matiastibaldo.cancioneromaestrodonbosco.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaCanciones extends android.support.v4.app.Fragment {
    private ListView listView1;
    private ArrayAdapter<String> listAdapter1;

    public ListaCanciones() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_lista_canciones, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);

        ArrayList<Cancion> canciones = new ArrayList<>();
        canciones = ListaCancioncionesDB.getListaCanciones();
        ArrayList<String> nombreCanciones = new ArrayList<>();
        for (int i = 0; i < canciones.size(); i++) {
            nombreCanciones.add(canciones.get(i).getNombre());
        }
        listView1 = (ListView)getView().findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,nombreCanciones);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                String nombreCancionSeleccionada = (String) listView1.getItemAtPosition(position);
                final Integer pagina = ListaCancioncionesDB.getPageByName(nombreCancionSeleccionada);
                //Toast.makeText(getApplicationContext(), nombreCancionSeleccionada + "..." + position, Toast.LENGTH_LONG).show();

                DetalleCancion fragment = new DetalleCancion();

                Bundle bundle = new Bundle();
                bundle.putInt("pagina", pagina);
                fragment.setArguments(bundle);

                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Contenedor, fragment).addToBackStack(null).commit();

            }
        });
        };
    }



