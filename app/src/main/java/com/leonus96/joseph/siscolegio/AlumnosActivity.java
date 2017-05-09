package com.leonus96.joseph.siscolegio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AlumnosActivity extends AppCompatActivity {
    @BindView(R.id.User)  TextView _user;
    @BindView(R.id.card1) CardView _nino;
    @BindView(R.id.card2) CardView _nina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Selecciona un alumno");
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        final Intent intent = new Intent(this, AgendaActivity.class);
        final Bundle bundle = new Bundle();

        _nino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putInt("id", 1);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        _nina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putInt("id", 2);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });


    }

}
