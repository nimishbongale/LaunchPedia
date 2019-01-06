package com.example.nimishbongale.list;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    ImageView iv;
    private Button loc;
    private Button map;
    private Button live;
    //recyclerView.invalidate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle bundle=getIntent().getExtras();
        final Intent intent = getIntent();
        String message = intent.getStringExtra("payload");
        String message1 = intent.getStringExtra("longdesc");
        iv=(ImageView)findViewById(R.id.imageView2);

        int a=bundle.getInt("secimg");

        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
        TextView textView1 = findViewById(R.id.textView1);
        textView1.setText(message1);

        iv.setImageResource(a);

        loc=(Button)findViewById(R.id.btnloc);
        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Intent.ACTION_VIEW, Uri.parse(intent.getStringExtra("locat")));
                startActivity(intent1);
                }
        });
        map=(Button)findViewById(R.id.btnmap);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(Intent.ACTION_VIEW, Uri.parse(intent.getStringExtra("url")));
                startActivity(it);
                }
        });
        live=(Button)findViewById(R.id.btnliv);
        live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.rocketlaunch.live/"));
                startActivity(it);
            }
        });
    }
}
