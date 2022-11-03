package com.example.travel4you;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    private TextView resetPassword;
    private EditText editTextEmail, editTextPassword;
    private Button register, login;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = (EditText) findViewById(R.id.loginEmailEditTxt);
        editTextPassword = (EditText) findViewById(R.id.loginPasswordEditTxt);

        mAuth = FirebaseAuth.getInstance();

        register = (Button) findViewById(R.id.createUserBttn);
        register.setOnClickListener(this);

        login = (Button) findViewById(R.id.loginBttn);
        login.setOnClickListener(this);

        resetPassword = (TextView) findViewById(R.id.resetPasswordTxt);
        resetPassword.setOnClickListener(this);

        progressBar = (ProgressBar) findViewById(R.id.loginProgressBar);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.createUserBttn:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.loginBttn:
                loginUser();
                break;
            case R.id.resetPasswordTxt:
                startActivity(new Intent(this, ResetPasswordActivity.class));
                break;
        }
    }

    private void loginUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty()) {
            editTextEmail.setError("Please enter the email");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Please enter a valid email");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Please enter the password");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextPassword.setError("Please enter a longer password");
            editTextPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        }else{
                            Toast.makeText(LoginActivity.this, "There has been an error!", Toast.LENGTH_SHORT).show();
                        }
                        progressBar.setVisibility(View.GONE);
                    }
                });

    }
}