package barchallenges.ima.ulaval.ca.barchallenge;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Vector;

import util.ASyncURLRequest;
import util.HttpCustomRequest;
import util.Util;

public class ConnectionActivity extends AppCompatActivity {
    String  mValide="true";



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences prefs = getSharedPreferences("IMA_PREF", MODE_PRIVATE);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_connection);

        if(prefs.contains("name")){
            String name = prefs.getString("name", null);
            EditText NomT = (EditText) findViewById(R.id.editTextNom);
            EditText CourrielT = (EditText) findViewById(R.id.editTextCourriel);
            TextView NomV = (TextView) findViewById(R.id.textViewNom);
            TextView CourrielV = (TextView) findViewById(R.id.textViewCourriel);
            TextView NomUtilisateur = (TextView) findViewById(R.id.textViewReconnexion);
            Button Login = (Button) findViewById(R.id.buttonConnexion);
            Button Login2 = (Button) findViewById(R.id.buttonConnexion2);

            NomT.setVisibility(View.INVISIBLE);
            CourrielT.setVisibility(View.INVISIBLE);
            NomV.setVisibility(View.INVISIBLE);
            CourrielV.setVisibility(View.INVISIBLE);
            Login.setVisibility(View.INVISIBLE);
            Login2.setVisibility(View.VISIBLE);
            NomUtilisateur.setVisibility((View.VISIBLE));
            NomUtilisateur.setText("Bienvenue " + name);
        }

    }

    public void onClickLogin(View v) {

        EditText Nom = (EditText) findViewById(R.id.editTextNom);
        String sNom = Nom.getText().toString();
        EditText Courriel = (EditText) findViewById(R.id.editTextCourriel);
        String sCourriel = Courriel.getText().toString();
        //loadEmailResults();

        //Nom imcomplet:
        if (sNom.matches("")) {
            Toast.makeText(this, "Nom imcomplet", Toast.LENGTH_SHORT).show();
        }
        //Courriel imcomplet:
        else if (sCourriel.matches("")) {
            Toast.makeText(this, "Courriel imcomplet", Toast.LENGTH_SHORT).show();
        }

        //Confirmation par un post
        //Courriel invalide:
        else if (!mValide.matches("true")) {
           Toast.makeText(this, "Courriel invalide", Toast.LENGTH_SHORT).show();
        }

        else {
            SharedPreferences.Editor editor = getSharedPreferences("IMA_PREF", MODE_PRIVATE).edit();
            editor.putString("name", sNom);
            editor.putString("courriel", sCourriel);
            editor.apply();


            //Test d'acces au prefs
            //SharedPreferences prefs = getSharedPreferences("IMA_PREF", MODE_PRIVATE);
            //String name = prefs.getString("name", null);
            //Log.d("Test nom utilisateur", name);

                Intent i=new Intent(this, Challenge_liste.class);
                startActivity(i);
                finish();
        }
    };

    public void onClickLogin2(View v) {
        Intent i=new Intent(this, Challenge_liste.class);
        startActivity(i);
        finish();
    }

    //Methode du POST
    private void loadEmailResults(){String urlToLoad = Util.getFormatedEmailURL(getApplicationContext());
        EditText Courriel = (EditText) findViewById(R.id.editTextCourriel);
        String sCourriel = Courriel.getText().toString();
        HttpCustomRequest request = new HttpCustomRequest(this, urlToLoad);
        request.setMethod("POST");

        String body = " {\"X-Mashape-Key\":" + "unEcfIBHqAmshcXSsAczXy9WW5Sjp1D4pFfjsnjOWtppn9HfYf" + ",";
        body += "\"Content-Type\": " + "application/x-www-form-urlencoded" + ",";
        body += "\"Accept\":application/json,";
        body += "\"email\": \"" + sCourriel;
        Log.d("Request:", body);
        request.setBody(body);


        ASyncURLRequest loadRequest = new ASyncURLRequest() {
            @Override
            protected void onPostExecute(String s) {
                if(s==null){
                    Log.d("EmailCheck", "the value returned is null");
                    return;
                }
                try {
                    JSONObject inData = new JSONObject(s);
                    Log.d("Email", "data " + inData);

                    mValide = inData.getString("valid");

                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("Email", "onGetExecute json error : " + e);
                }
            }
        };
        loadRequest.execute(request);

    }

}

