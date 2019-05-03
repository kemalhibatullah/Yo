package com.example.yo;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView textDate, textPrice, textSubtitle;
    Button setIndo, setEng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textDate = findViewById(R.id.date);
        textPrice = findViewById(R.id.price);
        textSubtitle = findViewById(R.id.subtitle);

        Date myDate = new Date();
        String myFormatDate = DateFormat.getDateInstance().format(myDate);
        textDate.setText(myFormatDate);

        int myPrice = 1000000;
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        String myFormattedPrice = currencyFormat.format(myPrice);
        textPrice.setText(myFormattedPrice);

        textSubtitle.setText(getString(R.string.subtitle));
    }

    public void setIndo (View view){

        setIndo = findViewById(R.id.tombolIndo);

        setLocale("id");
    }

    public void setEng (View view){
        setEng = findViewById(R.id.tombolEng);
        setLocale("en");
    }

    public void setLocale(String lang){
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        recreate();
    }
}
