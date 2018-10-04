package com.example.duvan.peluchitosapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class InventarioFragment extends Fragment {

    private TextView tMostrarInventario;
    public InventarioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_inventario, container, false);

        tMostrarInventario = view.findViewById(R.id.tMostrarInventario);

        Bundle data = getArguments();
        tMostrarInventario.setText(data.getString("codigo"+ "," + "nombre"+ "," +"cantidad"+ "," +"precio" ));

        return view;

    }

}
