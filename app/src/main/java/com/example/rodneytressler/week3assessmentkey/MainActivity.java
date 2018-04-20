package com.example.rodneytressler.week3assessmentkey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AccountFragment.CallBack{

    @BindView(R.id.welcome_text)
    protected TextView welcomeText;
    private AccountFragment accountFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        accountFragment.newInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        AccountFragment startFragment = new AccountFragment().newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, startFragment).commit();
        startFragment.attackParent( this);

    }

    @Override
    public void createAccount(String accountName, String accountClass) {
        getSupportFragmentManager().beginTransaction().remove(AccountFragment.newInstance());
    }
}
