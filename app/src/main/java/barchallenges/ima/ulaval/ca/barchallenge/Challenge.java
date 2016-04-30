package barchallenges.ima.ulaval.ca.barchallenge;

import android.os.Parcel;
import android.os.Parcelable;


public class Challenge implements Parcelable{

        private String mName;
        private String mDescription;
        private boolean mDone;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            out.writeString(mName);
            out.writeString(mDescription);
            out.writeSerializable(mDone);
        }

        public Challenge(String pName, String pDescription, Boolean pDone)
        {
            mName = pName;
            mDescription = pDescription;
            mDone = pDone;

        }

        public String GetName(){return mName;}
        public String GetDescription(){return mDescription;}
        public boolean GetDone(){return mDone;}
        public void setDone(boolean pValue){mDone = pValue;}
        public void completed(){mDone = true;}

    public static final Creator<Challenge> CREATOR
            = new Creator<Challenge>() {
        public Challenge createFromParcel(Parcel in) {
            return new Challenge(in);
        }

        public Challenge[] newArray(int size) {
            return new Challenge[size];
        }
    };

        private Challenge(Parcel in)
        {
            mName = in.readString();
            mDescription = in.readString();
            mDone = (Boolean) in.readSerializable();
        }
}

