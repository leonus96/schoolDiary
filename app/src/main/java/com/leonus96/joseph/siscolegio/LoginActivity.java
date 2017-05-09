package com.leonus96.joseph.siscolegio;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;


    @BindView(R.id.inputEmail) EditText _emailText;
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


    private boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty()) {
            _emailText.setError("Ingresa un e-mail valido");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 15) {
            _passwordText.setError("Contraseña entre 4 y 15 caracteres alfanumericos");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
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

        String dni = _emailText.getText().toString();
        String constraseña = _passwordText.getText().toString();

        //TODO: implementar aqui logica de autenticación!

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




}
