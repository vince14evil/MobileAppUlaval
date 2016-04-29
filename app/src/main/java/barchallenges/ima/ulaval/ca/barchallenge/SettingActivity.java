package barchallenges.ima.ulaval.ca.barchallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setupToolbar();
    }

    private void setupToolbar()
    {
        Toolbar toolbarTop = (Toolbar) findViewById(R.id.toolbar_bottom);
        setSupportActionBar(toolbarTop);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void onReinitClick(View view)
    {
        PrizeManager.getInstance().reinitializePrizes(getApplicationContext());
    }

    public void onPrizeClick(View view) {
        Intent addEntryIntent = new Intent(getApplicationContext(), PrizeView.class);
        startActivity(addEntryIntent);
    }

    public void onHomeClick(View view) {
        Intent addEntryIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(addEntryIntent);
    }
}
