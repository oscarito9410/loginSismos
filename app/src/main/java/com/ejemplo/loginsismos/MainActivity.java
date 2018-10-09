package com.ejemplo.loginsismos;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import pl.bclogic.pulsator4droid.library.PulsatorLayout;

public class MainActivity extends AppCompatActivity {

    private PulsatorLayout pulsator;
    private EditText etUser, etPassWord;
    private TextView tvSesion,tvTerminos1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pulsator = (PulsatorLayout) findViewById(R.id.pulsator);
        pulsator.start();

        etPassWord=(EditText)findViewById(R.id.etPassword);
        tvSesion = (TextView)findViewById(R.id.tvSesion);
        tvTerminos1 = (TextView)findViewById(R.id.tvTerminos1);

        tvTerminos1.setText(Html.fromHtml(getResources().getString(R.string.textoNegritaLegales)));

        etPassWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null) {
                    if (s.toString().trim().length() >= 5) {
                        tvSesion.setBackgroundResource(R.drawable.shape_login_corner_enable);
                        tvSesion.setEnabled(true);
                        tvSesion.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.blanco));
                    } else {
                        tvSesion.setBackgroundResource(R.drawable.shape_login_corner);
                        tvSesion.setEnabled(false);
                    }
                } else {
                    tvSesion.setBackgroundResource(R.drawable.shape_login_corner);
                    tvSesion.setEnabled(false);

                }
            }
        });
    }
}