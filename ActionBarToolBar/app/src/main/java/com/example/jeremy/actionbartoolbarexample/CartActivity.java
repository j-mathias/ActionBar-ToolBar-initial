package com.example.jeremy.actionbartoolbarexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CartActivity extends AppCompatActivity{

    private int cartCounter;

    private int price = 80;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Toolbar toolbar = (Toolbar) findViewById(R.id.custom_toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        cartCounter=getIntent().getIntExtra("articlesInCart",0);

        TextView bottomCounter = (TextView) findViewById(R.id.bottom_counter);
        bottomCounter.setText(cartCounter + " articles dans le panier.");

        TextView article_qty = (TextView) findViewById(R.id.article_qty);
        article_qty.setText(String.valueOf(cartCounter));

        TextView final_price = (TextView) findViewById(R.id.final_price);
        final_price.setText(String.valueOf(cartCounter * price) + " €");

        Button keepShopping = (Button) findViewById(R.id.backToShoppingButton);
        keepShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        Button payment = (Button) findViewById(R.id.paymentButton);
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), R.string.payment_message, Toast.LENGTH_LONG).show();
            }
        });


    }
}
