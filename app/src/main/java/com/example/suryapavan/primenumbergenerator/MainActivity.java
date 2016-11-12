package com.example.suryapavan.primenumbergenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import static android.R.attr.max;
import static android.R.attr.max;

public class MainActivity extends AppCompatActivity {

    EditText editText1,editText2;
    Button button;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.edit1);
        editText2 = (EditText) findViewById(R.id.edit2);
        button = (Button) findViewById(R.id.button1);
        arrayList = new ArrayList<String>();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int min = Integer.parseInt(editText1.getText().toString());
                int max = Integer.parseInt(editText2.getText().toString());
                for (int i = min; i <= max; i++)
                {
                    if (isPrimeNumber(i))
                    {
                        arrayList.add(""+i);
                        min = i+1;
                    }
                }
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("mylist",arrayList);
                startActivity(intent);

            }
        });
    }

    public boolean isPrimeNumber(int number)
    {
        for (int i = 2; i <= number / 2; i++)
        {
            if (number % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}
