package barchallenges.ima.ulaval.ca.barchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class PrizeDescription extends AppCompatActivity {

    private Prize mPrize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prize_description);

        mPrize = getIntent().getParcelableExtra(Prize.EXTRA_NAME);

        ((TextView) findViewById(R.id.PrizeTitle)).setText(mPrize.getName());
        ((TextView) findViewById(R.id.PrizeDescription)).setText(mPrize.getDescription());
    }

    public void onUseClick(View pView)
    {
        mPrize.useIt();
        Intent intent = new Intent(getBaseContext(), PrizeView.class);
        startActivity(intent);
    }
}
