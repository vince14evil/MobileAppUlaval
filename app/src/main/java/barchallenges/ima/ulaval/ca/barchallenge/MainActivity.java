package barchallenges.ima.ulaval.ca.barchallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPrize = (Button)findViewById(R.id.buttonPrize);
        btnPrize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addEntryIntent = new Intent(getApplicationContext(), PrizeView.class);
                startActivity(addEntryIntent);
            }
        });

        Button btnChallenge2 = (Button)findViewById(R.id.buttonChallenge2);
        btnChallenge2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addEntryIntent = new Intent(getApplicationContext(), Challenge2Activity.class);
                startActivity(addEntryIntent);
            }
        });
    }
}
