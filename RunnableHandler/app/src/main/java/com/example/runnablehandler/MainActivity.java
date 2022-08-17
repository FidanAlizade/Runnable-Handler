package com.example.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.example.runnablehandler.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
Runnable runnable;
Handler handler;
int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        number = 0;

        binding.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler = new Handler(Looper.getMainLooper());
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        binding.textView.setText("Time: " + number);
                        number++;
                        binding.textView.setText("Time: " + number);
                        handler.postDelayed(runnable,1000);
                    }
                };
                handler.post(runnable);
                binding.btnStart.setEnabled(false);
            }
        });



        binding.btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            binding.btnStart.setEnabled(true);
            handler.removeCallbacks(runnable);
            number = 0;
            binding.textView.setText("Time: " +number);
            }
        });
    }
}