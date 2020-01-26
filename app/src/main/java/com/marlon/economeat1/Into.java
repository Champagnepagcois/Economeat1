package com.marlon.economeat1;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.marlon.economeat1.fragments.CenterFragment;
import com.marlon.economeat1.fragments.HomeFragment;
import com.marlon.economeat1.fragments.SearchFragment;


public class Into extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toogle;


    private HomeFragment homeFrangment;
    private SearchFragment searchFragment;
    private CenterFragment centerFragment;
    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*bloquea el giro de pantalla*/
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_into);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        BarraInferior();

        drawerLayout = findViewById(R.id.drawer);
        try {
            toolbar = findViewById(R.id.toolbar);
        } catch (Exception e) {
        }

        navigationView = findViewById(R.id.navigationView);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment myfragment = null;
        Class fragmentClass;

        switch (menuItem.getItemId()) {
            case R.id.profile:
                Intent intentRe = new Intent(Into.this, Profile.class);
                Into.this.startActivity(intentRe);

                Toast.makeText(getApplicationContext(), "Perfil", Toast.LENGTH_SHORT).show();
                break;

            case R.id.search:
                Intent intentSe = new Intent(Into.this, MainActivity.class);
                Into.this.startActivity(intentSe);
                Toast.makeText(getApplicationContext(), "Search selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add:

                Intent intentin = new Intent(Into.this, MainActivity.class);
                Into.this.startActivity(intentin);

                Toast.makeText(getApplicationContext(), "Add selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.internet:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://barry239.github.io/WebOS-Design/index-companies.html"));
                startActivity(browserIntent);
                Toast.makeText(getApplicationContext(), "Abriendo pagina", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                Intent intentReg = new Intent(Into.this, MainActivity.class);
                Into.this.startActivity(intentReg);
                Toast.makeText(getApplicationContext(), "Sesion cerrada", Toast.LENGTH_SHORT).show();
                Into.this.finish();
                break;
            case R.id.setting:
                Toast.makeText(getApplicationContext(), "Settings selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.us:
                Intent intentUs = new Intent(Into.this, MainActivity.class);
                Into.this.startActivity(intentUs);
                Toast.makeText(getApplicationContext(), "Us selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.app_exit:
                Toast.makeText(getApplicationContext(), "Aplicacion cerrada", Toast.LENGTH_SHORT).show();
                //Sirve para cerrar toda la aplicacion
                finishAffinity();
                break;
        }
        return false;

    }


    private void BarraInferior() {
        mMainFrame = (FrameLayout) findViewById(R.id.f1content);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);


        homeFrangment = new HomeFragment();
        searchFragment = new SearchFragment();
        centerFragment = new CenterFragment();

        setFragment(homeFrangment);


        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_home:
                        mMainNav.setItemBackgroundResource(R.color.graylight);
                        setFragment(homeFrangment);
                        return true;

                    case R.id.nav_center:
                        mMainNav.setItemBackgroundResource(R.color.graylight);
                        setFragment(centerFragment);
                        return true;

                    case R.id.nav_search:
                        mMainNav.setItemBackgroundResource(R.color.graylight);
                        setFragment(searchFragment);
                        return true;

                    default:
                        return false;
                }
            }


        });
    }


    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.f1content, fragment);
        fragmentTransaction.commit();
    }


}

/*-------------------------------------Toolbar, menu rapido---------------------------------------------

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add) {
            Toast.makeText(this, "Agregar nueva solucion", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, AddNote.class);
            startActivity(i);

        }
        if (item.getItemId() == R.id.searchs) {
            Intent in = new Intent(this, Search.class);
            startActivity(in);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
-------------------------------------------HASTA AQUI---------------------------------------------------------------*/

