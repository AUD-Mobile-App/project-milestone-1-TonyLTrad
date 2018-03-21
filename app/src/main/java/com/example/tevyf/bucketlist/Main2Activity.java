package com.example.tevyf.bucketlist;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar tool=findViewById(R.id.toolbar2);
        tool.setNavigationIcon(R.drawable.arrow);
        TextView datetxt=findViewById(R.id.textView);
        TextView maptxt=findViewById(R.id.textView2);
        final EditText date=findViewById(R.id.editText);
        tool.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        final DateFormat txtDate= DateFormat.getDateInstance();
        final Calendar c2=Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener d2= new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                c2.set(Calendar.YEAR,i);
                c2.set(Calendar.MONTH,i1);
                c2.set(Calendar.DAY_OF_MONTH,i2);
                date.setText(txtDate.format(c2.getTime()));
              }
        };
        datetxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Main2Activity.this,d2,c2.get(Calendar.YEAR),c2.get(Calendar.MONTH),c2.get(Calendar.DAY_OF_MONTH)).show();

            }
        });
    }
}
