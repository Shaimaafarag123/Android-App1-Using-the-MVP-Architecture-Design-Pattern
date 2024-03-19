
package com.example.myapplication;

public interface MainActivityContract {
    interface view{
        void onSuccess(String message);
        void onError(String message);


    }
    interface presenter{
        void doLogin(String email , String  password );
    }
}
