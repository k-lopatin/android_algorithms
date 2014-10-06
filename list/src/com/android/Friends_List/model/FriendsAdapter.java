package com.android.Friends_List.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;
import com.android.Friends_List.R;

import java.util.ArrayList;


/**
 * Created by Константин on 06.10.2014.
 */
public class FriendsAdapter extends ArrayAdapter<FriendModel> {
    public FriendsAdapter(Context context, int res, ArrayList<FriendModel> list) {
        super(context, res, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        FriendModel f = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.friend, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.nameText);
        TextView tvHome = (TextView) convertView.findViewById(R.id.descriptionText);
        // Populate the data into the template view using the data object
        tvName.setText(f.getName());
        tvHome.setText(f.getDescription());
        // Return the completed view to render on screen
        return convertView;
    }
}
