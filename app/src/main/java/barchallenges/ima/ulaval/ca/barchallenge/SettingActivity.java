package barchallenges.ima.ulaval.ca.barchallenge;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity  {

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
    }

    public void onReinitClick(View view)
    {
        PrizeManager.getInstance().reinitializePrizes(getApplicationContext());
        Toast.makeText(this, "Liste des prix réinitialisé", Toast.LENGTH_SHORT).show();
    }

    public void onReinitUtiClick(View view)
    {
        SharedPreferences.Editor editor = getSharedPreferences("IMA_PREF", MODE_PRIVATE).edit();
        editor.remove("name");
        editor.apply();
        Toast.makeText(this, "Utilisateur réinitialisé", Toast.LENGTH_SHORT).show();
    }

    public void onPrixButtonOnClick(View v) {

        Intent i=new Intent(getApplicationContext(), PrizeView.class);
        i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(i);
    }

    public void onMenuButtonOnClick(View v) {

        Intent i=new Intent(this, Challenge_liste.class);
        i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(i);
    }

    public void onOptionButtonOnClick(View v) {

        Intent i=new Intent(this, SettingActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(i);
    }
}
