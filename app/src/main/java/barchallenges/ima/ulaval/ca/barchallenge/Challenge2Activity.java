package barchallenges.ima.ulaval.ca.barchallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Vector;

import util.ASyncURLRequest;
import util.HttpCustomRequest;
import util.Util;

public class Challenge2Activity extends AppCompatActivity {
    private String mFName;
    private String mSName;
    private int mPercentage = 0;
    private String mResult;

    private boolean mPrizeWon = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge2);

        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadLoveCalculatorResults();
            }
        });
    }

    private void loadLoveCalculatorResults(){
        EditText fNameEditText = (EditText) findViewById(R.id.fNameText);
        EditText sNameEditText = (EditText) findViewById(R.id.sNameText);
        String fname = fNameEditText.getText().toString();
        String sname = sNameEditText.getText().toString();

        String urlToLoad= Util.getFormatedLoveCalcURL(getApplicationContext(), "?fname=" + fname + "&sname=" + sname);
        HttpCustomRequest request = new HttpCustomRequest(this,urlToLoad);
        List<Pair<String,String>> headers = new Vector<Pair<String, String>>();
        headers.add(new Pair("X-Mashape-Key","9gYvUwB5aemshxrDD3CaqXBhUArPp1alKhejsnkQQ73h2tlAMT"));
        headers.add(new Pair("Accept", "application/json"));
        request.setHeaders(headers);
        ASyncURLRequest loadRequest = new ASyncURLRequest(){
            @Override
            protected void onPostExecute(String s){

                if(s==null){
                    Log.d("Lovecalculator", "the value returned is null");
                    return;
                }
                try {
                    JSONObject inData = new JSONObject(s);
                    Log.d("Lovecalculator", "data " + inData);

                    //JSONArray lJsonArrayPromo = inData.getJSONArray("models");
                    mFName = inData.getString("fname");
                    mSName = inData.getString("sname");
                    mPercentage = Integer.parseInt(inData.getString("percentage"));
                    mResult = inData.getString("result");

                    updateView();
                    checkForPrize();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("lovecalculator", "onGetExecute json error : " + e);
                }
            }
        };
        loadRequest.execute(request);
    }

    void updateView(){
        TextView textViewFname = (TextView)findViewById(R.id.fNameText);
        textViewFname.setText(mFName);
        TextView textViewSname = (TextView)findViewById(R.id.sNameText);
        textViewSname.setText(mSName);
        TextView textViewPercentage = (TextView)findViewById(R.id.percentage);
        textViewPercentage.setText(String.valueOf(mPercentage));
        TextView textViewResult = (TextView)findViewById(R.id.result);
        textViewResult.setText(mResult);
    }

    void checkForPrize(){
        if(mPercentage >= 80){
            TextView textViewPrize = (TextView)findViewById(R.id.textPrize);
            textViewPrize.setText("Prix alloué!");
            if(!mPrizeWon) {
                PrizeManager.getInstance().earnNextPrize(getApplicationContext());
            }
            mPrizeWon = true;
        }
    }
}
