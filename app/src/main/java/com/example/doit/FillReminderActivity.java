package com.example.doit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.doit.databinding.ActivityFillReminderBinding;

public class FillReminderActivity extends AppCompatActivity {

    ActivityFillReminderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fill_reminder);
        binding = ActivityFillReminderBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportActionBar().hide();

//        Drop down menu
        String[] items = new String[] {"Easy","Medium","Hard","Important"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,items);
        binding.spinner.setAdapter(adapter);

    }
}