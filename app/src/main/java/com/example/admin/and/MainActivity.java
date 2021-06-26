package com.example.admin.and;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText To;
    private EditText Sub;
    private EditText Mesg;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        To = (EditText)findViewById(R.id.txt1);
        Sub = (EditText)findViewById(R.id.txt2);
        Mesg = (EditText)findViewById(R.id.txt3);
        btn = (Button)findViewById(R.id.btn4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_EMAIL, new String[]{To.getText().toString()});
                it.putExtra(Intent.EXTRA_SUBJECT,Sub.getText().toString());
                it.putExtra(Intent.EXTRA_TEXT,Mesg.getText());
                it.setType("message/rfc822");
                startActivity(Intent.createChooser(it,"Select"));
            }
        });
    }
}