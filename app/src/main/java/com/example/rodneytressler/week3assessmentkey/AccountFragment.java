package com.example.rodneytressler.week3assessmentkey;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by rodneytressler on 12/14/17.
 */

public class AccountFragment extends Fragment {

    @BindView(R.id.name_input)
    protected EditText nameInput;

    private CallBack callBack;

    @BindView(R.id.class_input)
    protected EditText classInput;

    @BindView(R.id.button_finish)
    protected Button buttonFinish;

    @OnClick(R.id.button_finish)
    protected void onFinishButtonClicked(View view) {

        String mage = "mage";
        String warrior = "warrior";
        String archer = "archer";
        String nameInputFinal = nameInput.getText().toString().toLowerCase();
        String classInputFinal = classInput.getText().toString().toLowerCase();

        if (nameInput.getText().toString().isEmpty() || classInput.getText().toString().isEmpty()) {
//          /* Didn't know if you wanted me to use my own code or not so I used the method given
//             and added my own code in grey in the class error section below just in case :)
//
// */

            showAlertDialog("Please fill in blanks");
        } else if (mage != classInputFinal || archer != classInputFinal || warrior != classInputFinal) {
//            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//            builder.setTitle("NO CLASS").setMessage("Class not recognized (Choose Warrior, Archer, or Mage");
            showAlertDialog("Please input warrior, archer, or mage");
        }


    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_creation, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public static AccountFragment newInstance() {

        Bundle args = new Bundle();

        AccountFragment fragment = new AccountFragment();
        fragment.setArguments(args);
        return fragment;
    }



    private void showAlertDialog(String message) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Light_Dialog);
        } else {
            builder = new AlertDialog.Builder(getContext());
        }
        builder.setTitle("Error")
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void attackParent(CallBack callBack) {
        this.callBack = callBack;
    }

    public interface CallBack {

        void createAccount(String accountName, String accountClass);
    }

    @OnClick(R.id.button_finish)
    protected void buttonFinishPressed() {


    }






}
