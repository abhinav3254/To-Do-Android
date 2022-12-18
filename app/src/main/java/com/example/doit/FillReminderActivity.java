package com.example.doit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.doit.database.DBHandler;
import com.example.doit.databinding.ActivityFillReminderBinding;

import java.util.Calendar;

public class FillReminderActivity extends AppCompatActivity {

    ActivityFillReminderBinding binding;

    String dateSave;
    String timeSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fill_reminder);
        binding = ActivityFillReminderBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportActionBar().hide();

//        Drop down menu
//        String[] items = new String[] {"Easy","Medium","Hard","Important"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,items);
//        binding.spinner.setAdapter(adapter);


//        setting up date and time


        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        binding.dateBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(FillReminderActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        binding.dateTV.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                        dateSave = dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
                    }
                },year,month,dayOfMonth);
                datePickerDialog.show();
            }
        });



        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);

        binding.timeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(FillReminderActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int min) {
                        binding.timeTV.setText(hour+":"+min);
                        timeSave = hour+":"+min;
                    }
                },hour,min,true);

                timePickerDialog.show();
            }
        });



//        doing backend stuff

        DBHandler dbHandler = new DBHandler(FillReminderActivity.this);

        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String categoryName = binding.categoryName.getText().toString();
                String message = binding.reminderName.getText().toString();

                Log.d("Abhinav", "yyyy: "+categoryName+" --> "+message+" --> "+dateSave+" --> "+timeSave);

                dbHandler.addNewData(categoryName,message,dateSave,timeSave);
                Toast.makeText(FillReminderActivity.this, "Added to the List", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(FillReminderActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
    /*
    * <!--    <androidx.appcompat.widget.AppCompatSpinner-->
    <!--        android:id="@+id/spinner"-->
    <!--        android:layout_width="match_parent"-->
    <!--        android:layout_height="50dp"-->
    <!--        android:background="@android:drawable/btn_dropdown"-->
    <!--        android:spinnerMode="dropdown"-->
    <!--        />-->*/
}