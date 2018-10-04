package com.example.duvan.peluchitosapp;

import android.app.ActionBar;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements comunicador {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private ArrayList<Peluches> peluchesArrayList;

    private PeluchesSQLiteHelper peluchesSQLiteHelper;
    private SQLiteDatabase sqLiteDatabase;
    //private ContentValues dataBD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));


        /**fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        AgregarFragment agregarFragment = new AgregarFragment();
        fragmentTransaction.add(android.R.id.content, agregarFragment).commit();*/

        //peluchesArrayList= new ArrayList<>();

        /**Peluches peluches = new Peluches(eCodigo.getText().toString(),
                ePrecio.getText().toString(),
                eCantidad.getText().toString(),
                eNombre.getText().toString());*/

        //peluchesArrayList.add(peluches);

        //Buscar
        //if (peluchesArrayList.get(0).getNombre().equals("Hulk")){}

        //Eliminar
        //peluchesArrayList.remove(0);

        peluchesSQLiteHelper = new PeluchesSQLiteHelper(this, "peluchesBD",
                null, 1);
        sqLiteDatabase = peluchesSQLiteHelper.getWritableDatabase();

    }

    @Override
    public void enviarDatos(String codigo, String nombre, String cantidad, String precio) {
        Bundle data = new Bundle();
        data.putString("codigo", codigo);
        data.putString("nombre", nombre);
        data.putString("cantidad", cantidad);
        data.putString("precio", precio);
        Toast.makeText(this, "Contacto Guardado", Toast.LENGTH_SHORT).show();

        /**fragmentTransaction = fragmentManager.beginTransaction();

        InventarioFragment inventarioFragment = new InventarioFragment();
        inventarioFragment.setArguments(data);

        fragmentTransaction.replace(android.R.id.content, inventarioFragment).commit();*/


    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    AgregarFragment agregarFragment = new AgregarFragment();

                    return agregarFragment;
                case 1:
                    BuscarFragment buscarFragment = new BuscarFragment();
                    return buscarFragment;
                case 2:
                    EliminarFragment eliminarFragment = new EliminarFragment();
                    return eliminarFragment;
                case 3:
                    InventarioFragment inventarioFragment = new InventarioFragment();
                    return inventarioFragment;
                default: return null;
            }
        }

        @Override
        public int getCount() {

            return 4;
        }
    }
}
