package barchallenges.ima.ulaval.ca.barchallenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PrizeAdapter extends BaseAdapter {
    private LayoutInflater mInflater = null;
    private ArrayList<Prize> mPrizeList;

    private final class ViewHolder {
        TextView TitleTextView;
        TextView NameTextView;
        TextView ShordDescriptionTextView;
    }

    private ViewHolder mHolder = null;

    public PrizeAdapter(Context context) {
        mPrizeList = new ArrayList<>();
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void add(Prize pStudent)
    {
        mPrizeList.add(pStudent);
    }

    @Override
    public int getCount() {
        return mPrizeList.size();
    }

    @Override
    public Object getItem(int position) {
        return mPrizeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            mHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.prize_cell, null);
            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder)convertView.getTag();
        }

        mHolder.TitleTextView = (TextView)convertView.findViewById(R.id.cellTitle);
        mHolder.TitleTextView.setText("Prize #" + (position + 1) + " : ");
        mHolder.NameTextView = (TextView)convertView.findViewById(R.id.cellName);
        mHolder.NameTextView.setText(mPrizeList.get(position).GetName());
        mHolder.ShordDescriptionTextView = (TextView)convertView.findViewById(R.id.cellDescription);
        mHolder.ShordDescriptionTextView.setText(mPrizeList.get(position).GetDescription());

        return convertView;
    }
}
