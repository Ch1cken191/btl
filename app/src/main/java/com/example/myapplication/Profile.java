package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity {
    private ImageView imageView;
    private TextView tvname,tvemail;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        init();
        showInformation();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thoat();
            }

        });
    }
    private void init(){
        button=findViewById(R.id.buttonBack);
        imageView = findViewById(R.id.img_avata);
        tvemail= findViewById(R.id.tv_email);
        tvname = findViewById(R.id.tv_name);
    }
    private void showInformation(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user==null){
            return;
        }
        String name=user.getDisplayName();
        String email=user.getEmail();
        Uri photoUrl = user.getPhotoUrl();
        if(name==null){
            tvname.setVisibility(View.GONE);
        }else{
            tvname.setVisibility(View.VISIBLE);
            tvname.setText(name);
        }

        tvemail.setText(email);
        Glide.with(this).load(photoUrl).error(R.drawable.ic_avata_de).into(imageView);
    }
    private void Thoat() {
        Intent intent = new Intent(Profile.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}