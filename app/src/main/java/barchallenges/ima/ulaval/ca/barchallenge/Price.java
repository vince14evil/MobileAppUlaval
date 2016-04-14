package barchallenges.ima.ulaval.ca.barchallenge;

import android.os.Parcel;
import android.os.Parcelable;

public class Price implements Parcelable {
    private String mName;
    private String mDescription;
    private boolean mEarned;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mDescription);
    }

    public static final Parcelable.Creator<Price> CREATOR
            = new Parcelable.Creator<Price>() {
        public Price createFromParcel(Parcel in) {
            return new Price(in);
        }

        public Price[] newArray(int size) {
            return new Price[size];
        }
    };

    private Price(Parcel in)
    {
        mDescription = in.readString();
    }
}
