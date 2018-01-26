package com.example.matiastibaldo.cancioneromaestrodonbosco.CInterfaces;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.matiastibaldo.cancioneromaestrodonbosco.R;
import com.github.barteksc.pdfviewer.PDFView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleCancion extends Fragment {


    public DetalleCancion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_cancion, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        int pagina=0;
        if (bundle != null) {
            pagina = bundle.getInt("pagina", 0);
            pagina=pagina+3; //porque el indice agrega 4 paginas
        }

        @SuppressLint("ResourceType") PDFView pdfView = (PDFView) getView().findViewById(R.id.detalle_cancion);
        pdfView.fromAsset("Cancionero MAESTRO completo con indice.pdf")
                .pages(pagina)
                .load();
        pdfView.enableSwipe(true);
        pdfView.fitToWidth(1);

    }


}
