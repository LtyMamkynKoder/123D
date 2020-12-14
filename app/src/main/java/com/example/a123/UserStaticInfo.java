package com.example.a123;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class UserStaticInfo {

    public final static String LOGIN = "login";
    public final static String POSITION = "position";
    public static List<User> users = new ArrayList<>();
    public  final static String USERS_SIGN_IN_INFO = "UsersSignInInfo";
    public  final static String USERS_PROFILE_INFO = "UsersProfileInfo";
    public  final static String PASSWORD = "password";
    public  final static String PROFILE_ID = "profileId";
    public  final static String NAME = "name";
    public  final static String AGE = "age";
    public  final static String STATE = "state";
    public static String profileId;
    public  final static String POSITION_LATITUDE = "Latitude";
    public  final static String POSITION_LONGITUDE = "Longitude";
    public static User ActiveUser;
    public UserStaticInfo() {
        if(users.size()==0)
            AddUsersInList();
    }

    private void AddUsersInList() {
        users.add(new User("Данил","Ya ystal",19,0));
        users.add(new User("Иван","Ya ystal",19,1));
        users.add(new User("Евгений","Ya ystal",19,2));
        users.add(new User("Алек","Отличная работа",19,1));
    }

}