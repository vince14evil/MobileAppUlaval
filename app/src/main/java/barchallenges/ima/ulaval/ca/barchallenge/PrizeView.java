package barchallenges.ima.ulaval.ca.barchallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class PrizeView extends AppCompatActivity {

    private PrizeAdapter mPrizeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prize_view);

        mPrizeAdapter = new PrizeAdapter(getApplicationContext());

        PrizeManager.getInstance().earnNextPrize();

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

    private void NavigateToDescription(Prize pStudent)
    {
        /*Intent intent = new Intent(getBaseContext(), .class);
        intent.putExtra("Student", pStudent);
        startActivity(intent);*/
    }
}
