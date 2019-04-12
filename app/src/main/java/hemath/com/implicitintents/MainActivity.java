package hemath.com.implicitintents;

import android.content.*;
import android.net.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent si = new Intent(Intent.ACTION_SEND);
                si.setType("message/rfc822");
                si.putExtra(Intent.EXTRA_EMAIL, new String[]{"support@support.com"});
                si.putExtra(Intent.EXTRA_SUBJECT, "Welcome to support");
                si.putExtra(Intent.EXTRA_TEXT, "Hi Guest, Welcome to support Tutorial Site");
                startActivity(Intent.createChooser(si,"Choose Mail App"));
            }
        });

        b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent si = new Intent(Intent.ACTION_SENDTO,Uri.fromParts(
                    "mailto","example@example.com", null));
      //    si.putExtra(Intent.EXTRA_EMAIL, new String[]{"example@example.com"});
            si.putExtra(Intent.EXTRA_SUBJECT, " support");
            si.putExtra(Intent.EXTRA_TEXT, "Dear customer, Please mail your query below.");
            startActivity(Intent.createChooser(si, "Send email..."));
            }
        });
    }
}
