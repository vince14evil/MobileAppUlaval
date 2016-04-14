package barchallenges.ima.ulaval.ca.barchallenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PriceAdapter extends BaseAdapter {


    private LayoutInflater mInflater = null;
    private ArrayList<Price> mPriceList;

    private final class ViewHolder {
        TextView nameTextView;
        TextView DescriptionTextView;
    }

    private ViewHolder mHolder = null;

    public PriceAdapter(Context context) {
        mPriceList = new ArrayList<>();
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void add(Price pStudent)
    {
        mPriceList.add(pStudent);
    }

    @Override
    public int getCount() {
        return mPriceList.size();
    }

    @Override
    public Object getItem(int position) {
        return mPriceList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*if(convertView == null) {
            mHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.student_cell, null);
            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder)convertView.getTag();
        }

        mHolder.nameTextView = (TextView)convertView.findViewById(R.id.cellName);
        mHolder.nameTextView.setText(mPriceList.get(position).getFirstName() + " " + studentList.get(position).getLastName());
        mHolder.programTextView = (TextView)convertView.findViewById(R.id.cellProgram);
        mHolder.programTextView.setText("   " + mPriceList.get(position).getDepartment().toString());
        mHolder.yearsTextView = (TextView)convertView.findViewById(R.id.cellYears);
        mHolder.yearsTextView.setText("Années d’université: " + studentList.get(position).getYearOfUniversity());
*/
        return convertView;
    }
}
