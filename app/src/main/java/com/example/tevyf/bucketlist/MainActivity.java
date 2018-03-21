package com.example.tevyf.bucketlist;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String [] title={"Travel with friends","Prank a professor"};
    String [] coordinates={"58,59","569.949"};
    String [] date={"18/02/18","19/03/18"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list=findViewById(R.id.bucketlist);
        CustomAdapter customAdapter=new CustomAdapter();
        list.setAdapter(customAdapter);
        FloatingActionButton button=findViewById(R.id.floatingActionButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });


    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
           view=getLayoutInflater().inflate(R.layout.customlayout,null);
           TextView txtdate=view.findViewById(R.id.textView6);
           TextView cordinates=view.findViewById(R.id.textView5);
           TextView txttile=view.findViewById(R.id.textView4);
            final CheckBox check=view.findViewById(R.id.checkBox2);
            txttile.setText(title[i]);
            txtdate.setText(date[i]);
            cordinates.setText(coordinates[i]);
            check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(check.isChecked()){
                        check.setText("Done");
                    }
                    else{
                        check.setText("Undone");
                    }
                }
            });
            return view;
        }
    }

}
