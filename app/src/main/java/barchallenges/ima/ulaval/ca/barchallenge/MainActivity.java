package barchallenges.ima.ulaval.ca.barchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbarTop = (Toolbar) findViewById(R.id.toolbar_bottom);
        setSupportActionBar(toolbarTop);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Button btnPrize = (Button)findViewById(R.id.buttonPrize);
        btnPrize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addEntryIntent = new Intent(getApplicationContext(), PrizeView.class);
                startActivity(addEntryIntent);
            }
        });

        SetupSelfieChallengeBouton();

        Button btnChallenge2 = (Button)findViewById(R.id.buttonChallenge2);
        btnChallenge2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addEntryIntent = new Intent(getApplicationContext(), Challenge2Activity.class);
                startActivity(addEntryIntent);
            }
        });
    }

    private void SetupSelfieChallengeBouton()
    {
        findViewById(R.id.buttonChallenge1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addEntryIntent = new Intent(getApplicationContext(), SelfieChallengeActivity.class);
                startActivity(addEntryIntent);
            }
        });
    }
}
