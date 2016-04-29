package barchallenges.ima.ulaval.ca.barchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class PrizeDescription extends AppCompatActivity {

    private Prize mPrize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prize_description);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mPrize = getIntent().getParcelableExtra(Prize.EXTRA_NAME);

        ((TextView) findViewById(R.id.PrizeTitle)).setText(mPrize.getName());
        ((TextView) findViewById(R.id.PrizeDescription)).setText(mPrize.getDescription());

        if(!mPrize.getIsEarned())
        {
            findViewById(R.id.btnUsePrize).setVisibility(View.INVISIBLE);
            TextView errorText = ((TextView)findViewById(R.id.textPrizeError));
            errorText.setVisibility(View.VISIBLE);
            errorText.setText("Le prix n'est pas débloqué.");
        }
        else if(mPrize.getIsUsed())
        {
            findViewById(R.id.btnUsePrize).setVisibility(View.INVISIBLE);
            TextView errorText = ((TextView)findViewById(R.id.textPrizeError));
            errorText.setVisibility(View.VISIBLE);
            errorText.setText("Le prix a déjà été utilisé.");
        }
        else
        {
            findViewById(R.id.btnUsePrize).setVisibility(View.VISIBLE);
            findViewById(R.id.textPrizeError).setVisibility(View.INVISIBLE);
        }
    }

    public void onUseClick(View pView) {
        PrizeManager.getInstance().usePrize(mPrize, getApplicationContext());
        Intent intent = new Intent(getBaseContext(), PrizeView.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
