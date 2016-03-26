package com.zackstrife.hugo.capezzone;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private DessinView dessin;
    private Button Btnred,Btnblue,Btnblack,Btnyel,Btnrand,Btnclear;
    private TextView size;
    private EditText weight;
    private String color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dessin= (DessinView)findViewById(R.id.DessinView);
        Btnblack= (Button)findViewById(R.id.BtnBlack);
        Btnblue= (Button)findViewById(R.id.BtnBlue);
        Btnred= (Button)findViewById(R.id.BtnRed);
        Btnyel=(Button)findViewById(R.id.BtnYel);
        Btnrand=(Button)findViewById(R.id.BtnRand);
        Btnclear=(Button)findViewById(R.id.BtnClear);
        weight= (EditText)findViewById(R.id.editText);

        Btnblue.setOnClickListener(new setcolorblue());
        Btnred.setOnClickListener(new setcolorred());
        Btnblack.setOnClickListener(new setcolorblack());
        Btnyel.setOnClickListener(new setcoloryellow());
        Btnrand.setOnClickListener(new setcolorrandom());
        Btnclear.setOnClickListener(new clear());


        weight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                dessin.setStroke(Integer.parseInt(weight.getText().toString()));
                Toast.makeText(MainActivity.this, "Stroke width changed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class setcolorblue implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            dessin.setPaintColor(Color.BLUE);
        }
    }

    private class setcolorred implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            dessin.setPaintColor(Color.RED);
        }
    }

    private class setcolorblack implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            dessin.setPaintColor(Color.BLACK);
        }
    }

    private class setcoloryellow implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            dessin.setPaintColor(Color.YELLOW);
        }
    }

    private class setcolorrandom implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Random color = new Random();
            dessin.setPaintColor(Color.rgb(color.nextInt(256), color.nextInt(256), color.nextInt(256)));
        }
    }

    private class clear implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            dessin.path.reset();
            dessin.invalidate();
        }
    }
}
