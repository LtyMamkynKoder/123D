package com.example.a123;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class User {
    private String Name, State;
    private int Age;
    private int StateSignal;

    public User(DataSnapshot dataSnapshot) {
        Object NameObj = dataSnapshot.child(NAME).getValue();
        if(NameObj!=null)
            Name = NameObj.toString();
        Object StateObj = dataSnapshot.child(STATE).getValue();
        if(StateObj!=null)
            State = StateObj.toString();
        Object AgeObj = dataSnapshot.child(AGE).getValue();
        if(AgeObj!=null)
            Age = parseIntOrDefault(AgeObj.toString(),0);

    }

    public int getStateSignal() {
        return StateSignal;
    }

    public void setStateSignal(int stateSignal) {
        StateSignal = stateSignal;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public User(String name, String state, int age, int stateSignal) {
        Name = name;
        State = state;
        Age = age;
        StateSignal = stateSignal;

    }

}