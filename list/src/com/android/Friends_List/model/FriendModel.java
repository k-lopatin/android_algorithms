package com.android.Friends_List.model;

import android.app.Activity;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

/**
 * Created by Администратор on 06.10.2014.
 */
public class FriendModel {
    private ArrayAdapter<String> adapter;
    private ArrayList<String> list;

    public FriendModel(Activity act) {
        list = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(act,
                android.R.layout.simple_list_item_multiple_choice, list);
    }

    public void add(String name) {
        if(name.length() > 1){
            adapter.insert(name, adapter.getCount());
        }
    }

    public void delete(int pos) {
        list.remove( pos );
        adapter.notifyDataSetChanged();
    }

    public ArrayAdapter getAdapter() {
        return adapter;
    }
}
