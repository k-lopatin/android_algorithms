package com.android.Friends_List.model;

import android.app.Activity;
import android.text.Layout;
import android.widget.ArrayAdapter;
import com.android.Friends_List.R;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Администратор on 06.10.2014.
 */
public class FriendsModel {
    private ArrayAdapter<FriendModel> adapter;
    private ArrayList<FriendModel> list;
    private ArrayList<FriendModel> listCur;
    private int currentID;
    private FriendModel currentFriend;

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

    public void delete(int id) {
        for(Iterator i = listCur.iterator(); i.hasNext(); ) {
            if( ((FriendModel)i.next()).getId() == id ) {
                i.remove();
            }
        }
        deleteChildren(id);
        adapter.notifyDataSetChanged();
    }

    private void deleteChildren(int id) {
        for(Iterator i = list.iterator(); i.hasNext(); ) {
            FriendModel f = (FriendModel) i.next();
            if(f.getId() == id){
                i.remove();
            }
            if(f.getParentID() == id) {
                i.remove();
                deleteChildren(f.getId());
            }
        }
    }

    public void showChildren(int parent) {
        listCur.clear();
        for(FriendModel f : list){
            if(f.getParentID() == parent){
                listCur.add(f);
            }
            if(f.getId() == parent){
                currentFriend = f;
            }
        }
        adapter.notifyDataSetChanged();
        currentID = parent;
    }
    public void goBack() {
        if(currentID != 0) {
            listCur.clear();
            currentID = currentFriend.getParentID();
            for(FriendModel f : list){
                if(f.getParentID() == currentID){
                    listCur.add(f);
                }
                if(f.getId() == currentID){
                    currentFriend = f;
                }
            }
            adapter.notifyDataSetChanged();
        }
    }

    public String getCurrentFriendName(){
        if(currentID != 0){
            return currentFriend.getName();
        } else {
            return "";
        }

    }


    public int getCurrentID() {
        return currentID;
    }

    public ArrayAdapter getAdapter() {
        return adapter;
    }
}
