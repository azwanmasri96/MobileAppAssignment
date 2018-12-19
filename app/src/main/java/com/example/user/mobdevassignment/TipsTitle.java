package com.example.user.mobdevassignment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TipsTitle extends ListFragment {
    boolean mDualPane;
    int mCurCheckPosition = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, TipsInfo.TITLES));

        View detailsFrame = getActivity().findViewById(R.id.details);
        mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        if(savedInstanceState != null){
            mCurCheckPosition = savedInstanceState.getInt("ourChoice", 0);
        }

        if(mDualPane){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showDetails(mCurCheckPosition);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("ourChoice", mCurCheckPosition);
    }

    @Override
    public void onListItemClick(ListView l,View v, int position, long id){
        showDetails(position);
    }

    void showDetails(int index){
        mCurCheckPosition = index;

        if(mDualPane){
            getListView().setItemChecked(index, true);
            DetailsFragment details = (DetailsFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.details);

            if(details == null || details.getShownIndex() != index){
                details = DetailsFragment.newInstance(index);
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();

//                if(index == 0){
//                    ft.add(R.id.details, details);
//                }else {
                    ft.replace(R.id.details, details);
//                }
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }


        }else{
            Intent intent = new Intent();
            intent.setClass(getActivity(), DetailsActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);
        }
    }
}
