package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    private EditText accountedit,emailedit,passwordedit,RetypepasswordEdit;
    private Button btnLogin, btnRegister;
    private FirebaseAuth auth;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();
        emailedit=findViewById(R.id.edtEmail);
        passwordedit = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnMoveToLogin);
        btnRegister = findViewById(R.id.btnSignUp);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }

        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DangNhap();
            }


        });
    }
    private void Register() {
        String email,password;
        email=emailedit.getText().toString();
        password=passwordedit.getText().toString();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Input Email",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Input Password",Toast.LENGTH_SHORT).show();
            return;
        }

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Register SuccessFull",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUp.this,Login.class);
                    startActivity(intent);
                    finish();

                }else{
                    Toast.makeText(getApplicationContext(),"Register Faile",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void DangNhap() {
        Intent intent = new Intent(SignUp.this, Login.class);
        startActivity(intent);
        finish();
    }

}