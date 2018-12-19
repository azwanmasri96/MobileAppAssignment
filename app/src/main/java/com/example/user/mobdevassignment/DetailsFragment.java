package com.example.user.mobdevassignment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

    public static DetailsFragment newInstance(int index){
        DetailsFragment f = new DetailsFragment();

        Bundle args = new Bundle();
        args.putInt("index",index);
        f.setArguments(args);

        return f;
    }

    public int getShownIndex(){
        return getArguments().getInt("index",0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        if(container == null){
            return null;
        }

        ScrollView scroller = new ScrollView(getActivity());
        TextView text = new TextView(getActivity());
        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,4,getActivity().getResources().getDisplayMetrics());
        scroller.addView(text);
        text.setText(TipsInfo.DIALOGUE[getShownIndex()]);
        return scroller;
    }
}
