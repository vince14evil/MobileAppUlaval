package barchallenges.ima.ulaval.ca.barchallenge;

import android.os.Parcel;
import android.os.Parcelable;

public class Prize implements Parcelable {
    private String mName;
    private String mDescription;
    private boolean mEarned;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mName);
        out.writeString(mDescription);
        out.writeSerializable(mEarned);
    }

    public Prize(String pName, String pDescription)
    {
        mName = pName;
        mDescription = pDescription;
        mEarned = false;
    }

    public String GetName(){return mName;}
    public String GetDescription(){return mDescription;}
    public Boolean GetIsEarned(){return mEarned;}
    public void earn(){mEarned = true;}

    public static final Parcelable.Creator<Prize> CREATOR
            = new Parcelable.Creator<Prize>() {
        public Prize createFromParcel(Parcel in) {
            return new Prize(in);
        }

        public Prize[] newArray(int size) {
            return new Prize[size];
        }
    };

    private Prize(Parcel in)
    {
        mName = in.readString();
        mDescription = in.readString();
        mEarned = (Boolean) in.readSerializable();
    }
}
