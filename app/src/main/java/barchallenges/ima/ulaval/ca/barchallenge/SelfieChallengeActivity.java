package barchallenges.ima.ulaval.ca.barchallenge;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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
           mPhoto = (Bitmap) data.getExtras().get("data");
           ImageView imageView = (ImageView) findViewById(R.id.upload_image_preview);
           imageView.setImageBitmap(mPhoto);
        }
    }
}
