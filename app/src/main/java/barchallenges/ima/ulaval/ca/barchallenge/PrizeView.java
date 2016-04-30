package barchallenges.ima.ulaval.ca.barchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class PrizeView extends AppCompatActivity {

    private PrizeAdapter mPrizeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prize_view);

        Toolbar toolbarTop = (Toolbar) findViewById(R.id.toolbar_bottom);
        setSupportActionBar(toolbarTop);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mPrizeAdapter = new PrizeAdapter(getApplicationContext());

        createStudentAdapter();
        initListView();
        initAdpaterData();
    }

    private void initAdpaterData() {
        mPrizeAdapter.notifyDataSetChanged();
    }

    private void createStudentAdapter()
    {
        mPrizeAdapter = new PrizeAdapter(getApplicationContext());
    }

    private void initListView()
    {
        ListView studentList = (ListView) findViewById(R.id.studentList);
        studentList.setAdapter(mPrizeAdapter);
        studentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                navigateToDescription((Prize) mPrizeAdapter.getItem(position));
            }
        });
    }

    private void navigateToDescription(Prize pPrize)
    {
        Intent intent = new Intent(getBaseContext(), PrizeDescription.class);
        intent.putExtra(Prize.EXTRA_NAME, pPrize);
        startActivity(intent);
    }

    public void surPrixButtonOnClick(View v) {

        Intent i=new Intent(this, PrizeView.class);
        i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(i);
    }

    public void surMenuButtonOnClick(View v) {

        Intent i=new Intent(this, Challenge_liste.class);
        i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(i);
    }

    public void surOptionButtonOnClick(View v) {

        Intent i=new Intent(this, SettingActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(i);
    }
}
