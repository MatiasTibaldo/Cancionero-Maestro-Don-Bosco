package com.example.matiastibaldo.cancioneromaestrodonbosco.CInterfaces;

import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.matiastibaldo.cancioneromaestrodonbosco.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            onNavigationItemSelected(navigationView.getMenu().getItem(0));

        }
    }

    private boolean canExitApp = false;
    @Override
    public void onBackPressed() {

        DetalleCancion test = (DetalleCancion) getSupportFragmentManager().findFragmentByTag("Detalle Cancion");
        if (test != null && test.isVisible()) {            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
               if (drawer.isDrawerOpen(GravityCompat.START)) {
                   drawer.closeDrawer(GravityCompat.START);
               } else {
                   super.onBackPressed();
               }

           }else{
               if (!canExitApp) {
                   canExitApp = true;
                   Toast.makeText(this, "Presione nuevamente para salir", Toast.LENGTH_SHORT).show();

                   new Handler().postDelayed(new Runnable() {

                       @Override
                       public void run() {
                           canExitApp = false;
                       }
                   }, 2000);
               } else {
                   super.onBackPressed();
               }
           }




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
    android.support.v4.app.Fragment fragment=null;
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        switch (item.getItemId()){
            case R.id.Contenedor:
                fragment=new ListaCanciones();
                break;

            case R.id.Canciones:
                fragment=new ListaCanciones();
                break;

            case R.id.Cancionero:
                fragment= new TodasLasCanciones();
                break;

            case R.id.Ayuda:
                enviarEmail();
                break;

            case R.id.AcercaDe:
                fragment= new AcercaDe();
                break;

        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.Contenedor, fragment);
            ft.commit();

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        }
        return true;

    }

    private void enviarEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","matias.tiba@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Ayuda/Sugerencia Cancionero Maestro Don Bosco");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"mtibaldo@frsf.utn.edu.ar"});
        startActivity(Intent.createChooser(emailIntent, "Enviar email via..."));
    }
}
