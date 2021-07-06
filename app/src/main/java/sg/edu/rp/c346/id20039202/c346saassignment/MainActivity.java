package sg.edu.rp.c346.id20039202.c346saassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    TextView tv3;
    TextView tv5;
    Button btnWebsite;
    Button btnList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.textViewtext1);
        tv1.setPaintFlags(tv1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);  //Put underline under the text
        tv3 = findViewById(R.id.textViewtext3);
        tv3.setPaintFlags(tv3.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);  //Put underline under the text
        tv5 = findViewById(R.id.textViewtext5);
        tv5.setPaintFlags(tv5.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);  //Put underline under the text
        btnWebsite = findViewById(R.id.buttonWebsite);
        btnList = findViewById(R.id.buttonList);


        btnWebsite.setOnClickListener(new View.OnClickListener() {   //Create onClick method
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.amazon.com")); // Use implicit intent to launch website
                startActivity(i);

            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ItemListActivity.class);
                startActivity(intent);
            }
        });

    }
}