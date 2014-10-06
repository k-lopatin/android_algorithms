package com.android.Friends_List.model;

import android.app.Activity;
import android.text.Layout;
import android.widget.ArrayAdapter;
import com.android.Friends_List.R;

import java.util.ArrayList;

/**
 * Created by Администратор on 06.10.2014.
 */
public class FriendsModel {
    private ArrayAdapter<FriendModel> adapter;
    private ArrayList<FriendModel> list;
    private ArrayList<FriendModel> listCur;
    private int currentID;

    public FriendsModel(Activity act, int res) {
        listCur = new ArrayList<FriendModel>();
        list = new ArrayList<FriendModel>();
        adapter = new FriendsAdapter(act,
                res, listCur);
        currentID = 0;
    }

    public void add(String name, String description) {
        if(name.length() > 1){
            FriendModel f = new FriendModel(name, description, currentID);
            list.add(f);
            listCur.add(f);
            adapter.notifyDataSetChanged();
        }
    }

    public void delete(int pos) {
        list.remove( pos );
        adapter.notifyDataSetChanged();
    }

    public void showChildren(int parent) {
        listCur.clear();
        for(FriendModel f : list){
            if(f.getParentID() == parent){
                listCur.add(f);
            }
        }
        adapter.notifyDataSetChanged();
        currentID = parent;
    }
    public void goBack() {
        if(currentID == 0) return;
        listCur.clear();
        for(FriendModel f : list){
            if(f.getId() == currentID){
                currentID = f.getParentID();
                break;
            }
        }
        for(FriendModel f : list){
            if(f.getParentID() == currentID){
                listCur.add(f);
            }
        }
        adapter.notifyDataSetChanged();
    }

    public int getCurrentID() {
        return currentID;
    }

    public ArrayAdapter getAdapter() {
        return adapter;
    }
}
