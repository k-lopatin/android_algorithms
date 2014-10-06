package com.android.Friends_List.controller;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ListView;

import com.android.Friends_List.R;
import com.android.Friends_List.model.FriendModel;

public class FriendsActivity extends Activity {

    private ListView friendsList;
    private FriendModel friendModel;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        friendsList = (ListView) findViewById(R.id.friendsList);
        friendModel = new FriendModel(this);
        friendsList.setAdapter(friendModel.getAdapter());
    }

    public void onPlusBtnClick(View view) {
        DialogFragment dialog = new NewFriendDialogFragment();
        dialog.show(getFragmentManager(), "dialog");
    }

    public void onOkAddFriendClick(String name) {
        friendModel.add(name);
        friendsList.invalidate();
    }

    public void onDelFriendClick(View v) {
        SparseBooleanArray sbArr = friendsList.getCheckedItemPositions();
        int j = 0;
        for (int i = 0; i < sbArr.size(); i++) {
            int key = sbArr.keyAt(i);
            if (sbArr.get(key)) {
                friendsList.setItemChecked(key, false);
                friendModel.delete(key - j);
                j++;
            }
        }
        friendsList.invalidateViews();
    }

}
