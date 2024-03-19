package com.example.myapplication;

public class MainActivityPresenter implements MainActivityContract.presenter {
     MainActivityContract.view view;

    public MainActivityPresenter(MainActivityContract.view view) {
        this.view = view;
    }

    @Override
    public void doLogin(String email, String password) {

        if (email.equals("test@live.com") && password.equals("pass@123"))
        {
            view.onSuccess("Successful");
        }else {
            view.onError("wrong email or password ");
        }
    }
}
