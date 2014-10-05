package com.android.Friends_List;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class FriendsActivity extends Activity {



    private ArrayAdapter<String> adapter;
    ArrayList<String> lst;
    private ListView friendsList;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        friendsList = (ListView) findViewById(R.id.friendsList);
        /*values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2" };*/
        lst = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, lst);
        friendsList.setAdapter(adapter);
    }
    public void onPlusBtnClick(View view) {
        DialogFragment dialog = new NewFriendDialogFragment();
        dialog.show(getFragmentManager(), "dialog");
    }

    public void onOkAddFriendClick(String name) {
        adapter.insert(name, adapter.getCount());
        friendsList.invalidateViews();
    }

    public void onDelFriendClick(View v) {
        SparseBooleanArray sbArr = friendsList.getCheckedItemPositions();
        for (int i = 0; i < sbArr.size(); i++) {
            int key = sbArr.keyAt(i);
            if (sbArr.get(key)){
                friendsList.setItemChecked(key, false);
                lst.remove( key );
                adapter.notifyDataSetChanged();
                friendsList.invalidateViews();
            }
        }
    }

}
