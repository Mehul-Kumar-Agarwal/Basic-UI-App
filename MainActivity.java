package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private Button button;
    private CheckBox checkBox;
    private RadioGroup radioGroup;
    private ProgressBar progressBar;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        String text = editText.getText().toString();
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        imageView=(ImageView)findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++)
                {
                    progressBar.incrementProgressBy(10);
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });
                thread.start();
    }


    public void Start(View view) {
        imageView.setVisibility(view.VISIBLE);
        TextView textView=(TextView)findViewById(R.id.textView);
        textView.setVisibility(view.VISIBLE);
        if (checkBox.isChecked()) {
            editText.setText("Checked");
        } else {
            editText.setText("Unchecked");
        }
        int id= radioGroup.getCheckedRadioButtonId();
        switch (id)
        {
            case R.id.rbMale:editText.setText("male");
            break;
            case R.id.rbFmale:editText.setText("Female");
            break;
            case R.id.rbothers:editText.setText("Others");
            break;
            default:editText.setText("DEFAULT");
            break;

        }
    }
}

