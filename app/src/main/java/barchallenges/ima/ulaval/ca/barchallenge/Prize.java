package barchallenges.ima.ulaval.ca.barchallenge;

import android.os.Parcel;
import android.os.Parcelable;

public class Prize implements Parcelable {
    public static final String EXTRA_NAME = "Prize";

    private int mId;
    private String mName;
    private String mDescription;
    private boolean mEarned;
    private boolean mIsUsed;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mId);
        out.writeString(mName);
        out.writeString(mDescription);
        out.writeSerializable(mEarned);
        out.writeSerializable(mIsUsed);
    }

    public Prize(int pId, String pName, String pDescription)
    {
        mId = pId;
        mName = pName;
        mDescription = pDescription;
        mEarned = false;
        mIsUsed = false;
    }

    public int getId(){return mId;}

    public String getName(){return mName;}
    public String getDescription(){return mDescription;}

    public Boolean getIsEarned(){return mEarned;}
    public void setEarned(boolean pValue){mEarned = pValue;}
    public void earn(){mEarned = true;}

    public Boolean getIsUsed(){return mIsUsed;}
    public void setIsUsed(boolean pValue){mIsUsed = pValue;}
    public void useIt(){mIsUsed = true;}

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
        mId = in.readInt();
        mName = in.readString();
        mDescription = in.readString();
        mEarned = (Boolean) in.readSerializable();
        mIsUsed = (Boolean) in.readSerializable();
    }
}
