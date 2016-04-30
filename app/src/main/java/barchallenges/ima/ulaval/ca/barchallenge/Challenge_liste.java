package barchallenges.ima.ulaval.ca.barchallenge;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Challenge_liste extends AppCompatActivity {
    ArrayList<Challenge> mChallengeList= ChallengeGenerator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_liste);

        ChallengeAdapter adapter = new ChallengeAdapter(this, R.layout.challenge_cell);
        ListView listview = (ListView) findViewById(R.id.listView);
        listview.setAdapter(adapter);
        adapter.addAll(mChallengeList);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final Challenge item = (Challenge) parent.getItemAtPosition(position);


                if (item.GetDescription().matches("Trouver une personne dans le bar dont vos deux noms ensemble donnera le meilleur résultat." )&& !item.GetDone()) {
                    item.setDone(true);
                    Intent intent = new Intent(Challenge_liste.this, Challenge2Activity.class);
                    startActivity(intent);
                }

                else if (item.GetDescription().matches("Prendre un selfie avec l'un des employés du bar.")&& !item.GetDone()) {
                    item.setDone(true);
                    Intent intent = new Intent(Challenge_liste.this, SelfieChallengeActivity.class);
                    startActivity(intent);
                }
                else if(item.GetDone()){
                    Toast.makeText(Challenge_liste.this, "Défi déjà essayé", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    public class ChallengeAdapter extends ArrayAdapter<Challenge> {

        public ChallengeAdapter(Context context, int textViewResourceId) {
            super(context, textViewResourceId);

        }
        class ViewHolder
        {
            TextView Description;
            TextView Nom;
            ImageView Image;
            ImageView Image2;


            ViewHolder(View v)
            {
                Nom= (TextView) v.findViewById(R.id.textViewChallenge);
                Description= (TextView) v.findViewById(R.id.textViewChallengeDesc);
                Image=(ImageView) v.findViewById(R.id.imageViewConfirme);

            }

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View cellule = convertView;
            ViewHolder holder= null;
            Challenge item = getItem(position);

            if (cellule == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                cellule = inflater.inflate(R.layout.challenge_cell,parent,false);
                holder=new ViewHolder(cellule);
                cellule.setTag(holder);

            } else {
                holder = (ViewHolder) cellule.getTag();
            }

            holder.Nom.setText(item.GetName());
            holder.Description.setText(item.GetDescription());

            if(item.GetDone()){
                holder.Image.setImageResource(R.drawable.incomplet);
            }
            if(!item.GetDone()){
                holder.Image.setImageResource(R.drawable.confirmer);

            }

            return cellule;
        }

    }

    //Génére une liste de 10 défis au hazard parmi les deux défis existants
    public ArrayList<Challenge> ChallengeGenerator()
    {
        ArrayList<Challenge> mChallengeList= new ArrayList<>();
        int compteur = 0;
        Random rand = new Random();

        for (int i = 0; i< 10;i++){

            compteur++;
            int n = rand.nextInt(2);

            if(n==0)
            {
                Challenge challenge1=new Challenge("DÉFI #"+compteur, "Trouver une personne dans le bar dont vos deux noms ensemble donnera le meilleur résultat.",false);
                mChallengeList.add(challenge1);
            };
            if(n==1)
            {
                Challenge challenge2=new Challenge("DÉFI #"+compteur, "Prendre un selfie avec l'un des employés du bar.",false);
                mChallengeList.add(challenge2);
            };
        };
        return mChallengeList;
    }

    //Action liée à la bar de menu au bas de l'écran
    public void PrixButtonOnClick(View v) {

        Intent i=new Intent(this, PrizeView.class);
        i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(i);
    }

    public void MenuButtonOnClick(View v) {

        Intent i=new Intent(this, Challenge_liste.class);
        i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(i);
    }

    public void OptionButtonOnClick(View v) {

        Intent i=new Intent(this, SettingActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(i);
    }

    public void onResume(){
        super.onResume();
        ChallengeAdapter adapter = new ChallengeAdapter(this, R.layout.challenge_cell);
        ListView listview = (ListView) findViewById(R.id.listView);
        listview.setAdapter(adapter);
        adapter.addAll(mChallengeList);
    }
    public void onRestart(){
        super.onRestart();
        ChallengeAdapter adapter = new ChallengeAdapter(this, R.layout.challenge_cell);
        ListView listview = (ListView) findViewById(R.id.listView);
        listview.setAdapter(adapter);
        adapter.addAll(mChallengeList);
    }

}
