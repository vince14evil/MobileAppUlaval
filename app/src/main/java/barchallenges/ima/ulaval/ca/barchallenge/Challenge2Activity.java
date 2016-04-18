package barchallenges.ima.ulaval.ca.barchallenge;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import util.ASyncURLRequest;
import util.HttpCustomRequest;
import util.Util;

public class Challenge2Activity extends AppCompatActivity {
    private String mFName;
    private String mSName;
    private int mPercentage = 0;
    private String mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge2);
    }

    private void loadLoveCalculatorResults(){
        EditText fNameEditText = (EditText) findViewById(R.id.fNameText);
        EditText sNameEditText = (EditText) findViewById(R.id.sNameText);
        String fname = fNameEditText.getText().toString();
        String sname = sNameEditText.getText().toString();

        String urlToLoad= Util.getFormatedLoveCalcURL(getApplicationContext(), "?fname=" + fname + "?sname=" + sname);
        HttpCustomRequest request = new HttpCustomRequest(this,urlToLoad);
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
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("lovecalculator", "onGetExecute json error : " + e);
                }
            }
        };
        loadRequest.execute(request);
    }
}
