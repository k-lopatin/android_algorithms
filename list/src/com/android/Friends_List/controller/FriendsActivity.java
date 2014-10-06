package com.android.Friends_List.controller;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import android.widget.TextView;
import com.android.Friends_List.R;
import com.android.Friends_List.model.FriendModel;
import com.android.Friends_List.model.FriendsModel;

public class FriendsActivity extends Activity {

    private ListView friendsList;
    private FriendsModel friendsModel;
    private TextView titleText;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        friendsList = (ListView) findViewById(R.id.friendsList);
        friendsModel = new FriendsModel(this, R.layout.friend);
        friendsList.setAdapter(friendsModel.getAdapter());

        titleText = (TextView) findViewById(R.id.title);

        friendsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                FriendModel f = (FriendModel)friendsModel.getAdapter().getItem(position);
                friendsModel.showChildren( f.getId() );
                titleText.setText(f.getName());
            }
        });
    }

    public void onPlusBtnClick(View view) {
        DialogFragment dialog = new NewFriendDialogFragment();
        dialog.show(getFragmentManager(), "dialog");
    }

    public void onOkAddFriendClick(String name, String desc) {
        friendsModel.add(name, desc);
        friendsList.invalidate();
    }

    public void onDelFriendClick(View v) {
        SparseBooleanArray sbArr = friendsList.getCheckedItemPositions();
        int j = 0;
        for (int i = 0; i < sbArr.size(); i++) {
            int key = sbArr.keyAt(i);
            if (sbArr.get(key)) {
                friendsList.setItemChecked(key, false);
                friendsModel.delete(key - j);
                j++;
            }
        }
        friendsList.invalidateViews();
    }

    public void onBackClick(View v) {
        friendsModel.goBack();
        friendsList.invalidateViews();
        titleText.setText( friendsModel.getCurrentFriendName() );
    }


    private void setTitle() {

    }





}
