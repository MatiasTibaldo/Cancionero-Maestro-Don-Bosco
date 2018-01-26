package com.example.matiastibaldo.cancioneromaestrodonbosco.CInterfaces;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.matiastibaldo.cancioneromaestrodonbosco.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AcercaDe extends Fragment {


    public AcercaDe() {
        // Required empty public constructor
    }
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_acerca_de, container, false);



    }
    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);

        button= (Button)getView().findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://drive.google.com/drive/folders/1Aj4K-Ijp-zfAztVm9qApKODeVG-1IYev"));
                startActivity(intent);
            }
        });


    }





    //https://drive.google.com/drive/folders/1Aj4K-Ijp-zfAztVm9qApKODeVG-1IYev


}
