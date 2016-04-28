package barchallenges.ima.ulaval.ca.barchallenge;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SelfieChallengeActivity extends AppCompatActivity {

    private Button mTakePhotoBtn;
    private int TAKE_PHOTO_INTENT=999;
    private int SELECT_IMAGE_INTENT=1234;
    private String mSelectedImagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selfie_challenge);

        mTakePhotoBtn = (Button) findViewById(R.id.TakePhotoBtn);
        mTakePhotoBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent cameraIntent = new Intent(
                        android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, TAKE_PHOTO_INTENT);
            }
        });
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==SELECT_IMAGE_INTENT && resultCode==RESULT_OK){
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            mSelectedImagePath=picturePath;
            ImageView imageView = (ImageView) findViewById(R.id.upload_image_preview);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }else if(requestCode==TAKE_PHOTO_INTENT && resultCode==RESULT_OK){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ImageView imageView = (ImageView) findViewById(R.id.upload_image_preview);
            imageView.setImageBitmap(photo);
            //we
        }
    }
}
