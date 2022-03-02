package com.example.class_work12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.class_work12.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding binding;
    ImageView imageView;
    private final int IMAGE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupData();
        transition();
    }

    private void setupData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("key");
    }

    private void transition() {
        binding.btnBrayzer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent brayzerIntent = new
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            }
        });
        binding.btnKamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new
                        Intent("android.media.action.IMAGE");
                startActivityForResult(intent, 0);
            }
        });
        binding.btnGalerey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoIntent = new Intent(Intent.ACTION_PICK);
                photoIntent.setType("image");
                startActivityForResult(photoIntent, IMAGE);
            }
        });
        binding.btnWhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("http://api.whatsapp.com/send?phone=557533788"));
                sendIntent.setPackage("whatsapp");
                startActivity(sendIntent);
            }
        });
        binding.btnTransactionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}