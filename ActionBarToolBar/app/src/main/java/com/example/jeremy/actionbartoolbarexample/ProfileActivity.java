package com.example.jeremy.actionbartoolbarexample;


import android.content.Intent;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.jeremy.actionbartoolbarexample.MainActivity.setBadgeCount;

public class ProfileActivity extends AppCompatActivity{

    private int cartCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Etape 7
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //Etape 8 et 7
        //getSupportActionBar().setDisplayShowTitleEnabled(true);

        cartCounter=getIntent().getIntExtra("articlesInCart",0);

        //Etape 13
        //TextView bottomCounter = (TextView) findViewById(R.id.bottom_counter);
        //bottomCounter.setText(cartCounter + " articles dans le panier.");

    }

    //Etape 10
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu, menu);

        if (cartCounter != 0) {
            MenuItem itemCart = menu.findItem(R.id.menu_cart);
            LayerDrawable icon = (LayerDrawable) itemCart.getIcon();
            setBadgeCount(this, icon, String.valueOf(cartCounter));
        }

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_cart:
                Intent cartActivity = new Intent(ProfileActivity.this, CartActivity.class);
                cartActivity.putExtra("articlesInCart", cartCounter);
                startActivity(cartActivity);
                return true;
            case R.id.menu_refresh:

                return true;
            case R.id.menu_help:
                Toast.makeText(getBaseContext(),R.string.help_text, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_profile:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    */

}
