package com.example.a123;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserActivity extends AppCompatActivity {

    private User activeUser;
    EditText NameTextView,StateTextView,AgeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        int position = getIntent().getIntExtra(POSITION, 0);
        activeUser = users.get(position);
        Init();
        setUserInfo();



    }

    private void setUserInfo() {
        NameTextView.setText(activeUser.getName());
        StateTextView.setText(activeUser.getState());
        AgeTextView.setText(String.valueOf(activeUser.getAge()));
    }

    private void Init() {
        NameTextView = findViewById(R.id.NameTextView);
        StateTextView = findViewById(R.id.StateTextView);
        AgeTextView = findViewById(R.id.AgeTextView);

    }

    public void Back(View view) {
        onBackPressed();
    }

    public void Save(View view) {
        activeUser.setName(NameTextView.getText().toString());
        activeUser.setState(StateTextView.getText().toString());
        String age = AgeTextView.getText().toString();

        activeUser.setAge(parseIntOfDefault(age,activeUser.getAge()));
        MainActivity.UpdateListAndUserPanel(activeUser);
        finish();
    }

}