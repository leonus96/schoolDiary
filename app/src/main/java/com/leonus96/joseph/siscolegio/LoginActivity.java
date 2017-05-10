package com.leonus96.joseph.siscolegio;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.leonus96.joseph.siscolegio.API.ColegioService;
import com.leonus96.joseph.siscolegio.Models.TokenManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;


    @BindView(R.id.inputEmail) EditText _dniText;
    @BindView(R.id.inputPassword) EditText _passwordText;
    @BindView(R.id.btnLogin) Button _loginButton;
    @BindView(R.id.linkSignup) TextView _signupLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        ButterKnife.bind(this); //seteamos todos los controles

        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    login();
                }
            }
        });

    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }


    private void login(){
        if(!validate()){
            onLoginFailed();
            return;
        }
        _loginButton.setEnabled(false);

        // Diálogo de progreso:
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this, R.style.Theme_AppCompat_DayNight_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Espere unos momentos...");
        progressDialog.show();

        String dni = _dniText.getText().toString();
        String constraseña = _passwordText.getText().toString();

        //TODO: implementar aqui logica de autenticación!
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ColegioService service = retrofit.create(ColegioService.class);

        Call<TokenManager> tokenCall = service.logIn(dni, constraseña);
        tokenCall.enqueue(new Callback<TokenManager>() {
            @Override
            public void onResponse(Call<TokenManager> call, Response<TokenManager> response) {
                TokenManager token = response.body();

            }

            @Override
            public void onFailure(Call<TokenManager> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Error de autenticación", Toast.LENGTH_LONG).show();
            }
        });
        new android.os.Handler().postDelayed( //funcionse ejecuta despues de 3000ms
                new Runnable() {
                    @Override
                    public void run() {
                        onLoginSuccess();
                        progressDialog.dismiss();
                    }
                }, 3000
        );
    }

    public void onLoginSuccess(){
        _loginButton.setEnabled(true);
        Intent intent = new Intent(getApplicationContext(), AlumnosActivity.class);
        startActivity(intent);
        finish();
    }

    public void onLoginFailed(){
        Toast.makeText(getBaseContext(), "No se pudo ingresar", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }



    private boolean validate() {
        boolean valid = true;

        String dni = _dniText.getText().toString();
        String password = _passwordText.getText().toString();

        if (dni.isEmpty()) {
            _dniText.setError("Ingresa un dni valido");
            valid = false;
        } else if(!dni.matches("\\d{8}")){
            _dniText.setError("DNI de solo 8 caracteres numéricos");
        } else{
            _dniText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 15) {
            _passwordText.setError("Contraseña entre 4 y 15 caracteres alfanumericos");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }



}
