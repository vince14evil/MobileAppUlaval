package barchallenges.ima.ulaval.ca.barchallenge;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SelfieChallengeActivity extends ActionBarActivity {

    private Button mTakePhotoBtn;
    private int TAKE_PHOTO_INTENT=999;
    private String mSelectedImagePath;
    private Bitmap mPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selfie_challenge);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.photoSelfieLayout).setVisibility(View.INVISIBLE);

        mTakePhotoBtn = (Button) findViewById(R.id.TakePhotoBtn);
        mTakePhotoBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(
                        android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, TAKE_PHOTO_INTENT);
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //Because there is a problem with orientation and camera
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data){
       if(requestCode==TAKE_PHOTO_INTENT && resultCode==RESULT_OK){

           findViewById(R.id.infoSelfieLayout).setVisibility(View.INVISIBLE);
           findViewById(R.id.photoSelfieLayout).setVisibility(View.VISIBLE);

           mPhoto = (Bitmap) data.getExtras().get("data");
           ImageView imageView = (ImageView) findViewById(R.id.upload_image_preview);
           imageView.setImageBitmap(mPhoto);
        }
    }

    public void SummitButtonOnClick(View v) {

        Intent i=new Intent(this, Challenge_liste.class);
        i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(i);
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
