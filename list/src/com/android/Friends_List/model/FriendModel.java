package com.android.Friends_List.model;

/**
 * Created by Константин on 06.10.2014.
 */
public class FriendModel {
    private String name;
    private String description;
    private int id;
    private int parentID;

    private static int count = 0;

    public FriendModel(String _name, String _description, int _parentID) {
        name = _name;
        description = _description;
        parentID = _parentID;
        count++;
        id = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public int getId() {
        return id;
    }

}
