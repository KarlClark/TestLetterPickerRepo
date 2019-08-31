package com.clarkgarrett.testletterpicker2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karl on 5/14/2016.
 */
public class LetterArrayAdapter extends ArrayAdapter{

    Context mContext;
    List<Character> mChars = new ArrayList<>();

    public LetterArrayAdapter(Context context, ArrayList<Character> chars) {
        super(context, R.layout.list_item, chars);
        mContext = context;
        mChars = chars;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }


        TextView tvLetters = (TextView)convertView.findViewById(R.id.tvLetters);
        tvLetters.setMinEms(1);
        tvLetters.setText(mChars.get(position).toString());

        return convertView;
    }

}
