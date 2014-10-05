package com.android.Friends_List;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Константин on 03.10.2014.
 */
public class NewFriendDialogFragment extends DialogFragment {
    private EditText friendsList;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();


        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        final View newFriendView = inflater.inflate(R.layout.newfriend, null);
        builder.setView(newFriendView);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                friendsList = (EditText) newFriendView.findViewById(R.id.friendName);
                ((FriendsActivity) getActivity()).onOkAddFriendClick(friendsList.getText().toString());
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                NewFriendDialogFragment.this.getDialog().cancel();
            }
        });
        return builder.create();
    }

   /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.newfriend, container, false);
        friendsList = (EditText) v.findViewById(R.id.friendName);
        return v;
    }*/
}
