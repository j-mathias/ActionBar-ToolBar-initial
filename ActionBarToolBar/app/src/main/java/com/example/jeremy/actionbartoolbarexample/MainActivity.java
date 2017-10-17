package com.example.jeremy.actionbartoolbarexample;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int cartCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addToCartButton = (Button) findViewById(R.id.cartButton);
        addToCartButton.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                cartCounter++;
                ActivityCompat.invalidateOptionsMenu(MainActivity.this);
            }
        });
    }


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
                Intent cartActivity = new Intent(MainActivity.this, CartActivity.class);
                cartActivity.putExtra("articlesInCart", cartCounter);
                startActivity(cartActivity);
                return true;
            case R.id.menu_refresh:

                return true;
            case R.id.menu_help:
                Toast.makeText(getBaseContext(),R.string.help_text, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_profile:
                Intent profileActivityIntent = new Intent(MainActivity.this, ProfileActivity.class);
                profileActivityIntent.putExtra("articlesInCart", cartCounter);
                startActivity(profileActivityIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    public static void setBadgeCount(Context context, LayerDrawable icon, String count) {

        BadgeDrawable badge;

        Drawable reuse = icon.findDrawableByLayerId(R.id.ic_badge);
        if (reuse != null && reuse instanceof BadgeDrawable) {
            badge = (BadgeDrawable) reuse;
        } else {
            badge = new BadgeDrawable(context);
        }

        badge.setCount(count);
        icon.mutate();
        icon.setDrawableByLayerId(R.id.ic_badge, badge);
    }

}
