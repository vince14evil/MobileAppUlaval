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

        CreateStudentAdapter();
        InitListView();
        InitAdpaterData();
    }

    private void InitAdpaterData() {
        mPrizeAdapter.notifyDataSetChanged();
    }

    private void CreateStudentAdapter()
    {
        mPrizeAdapter = new PrizeAdapter(getApplicationContext());
    }

    private void InitListView()
    {
        ListView studentList = (ListView) findViewById(R.id.studentList);
        studentList.setAdapter(mPrizeAdapter);
        studentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                NavigateToDescription((Prize) mPrizeAdapter.getItem(position));
            }
        });
    }

    private void NavigateToDescription(Prize pPrize)
    {
        Intent intent = new Intent(getBaseContext(), PrizeDescription.class);
        intent.putExtra(Prize.EXTRA_NAME, pPrize);
        startActivity(intent);
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
