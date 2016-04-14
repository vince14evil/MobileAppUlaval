package barchallenges.ima.ulaval.ca.barchallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PrizeView extends AppCompatActivity {

    private PrizeAdapter mPrizeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prize_view);

        mPrizeAdapter = new PrizeAdapter(getApplicationContext());

        CreateStudentAdapter();
        InitListView();
        InitAdpaterData();
    }

    private void InitAdpaterData() {
        List<Prize> myList = new ArrayList<>();
        myList.add(new Prize("Free Beer", "You can drink a beer with you friend!"));
        myList.add(new Prize("10% on a drink", "Choose waht you want to get drunk"));
        myList.add(new Prize("Free Shooter", "1.. 2.. 3.. SHOT!"));
        myList.add(new Prize("25% on a poutine", "If you are hungry..."));
        myList.add(new Prize("Free fries", "Because everyone love fries"));
        for (int i=0;i<myList.size();i++){
            mPrizeAdapter.add(myList.get(i));
        }
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
