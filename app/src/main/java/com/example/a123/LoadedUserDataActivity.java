package com.example.a123;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class LoadedUserDataActivity extends AppCompatActivity {

    MediaPlayer mPlayer;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loaded_user_data);
        Init();

    }

    private void goNext(DataSnapshot dataSnapshot) {
        ActiveUser = new User(dataSnapshot);
        Intent intent = new Intent(this,ProfileMapsActivity.class);
        startActivity(intent);
        finish();
        myRef.removeEventListener(eventListener);
    }

    private void Init() {
        mPlayer = MediaPlayer.create(this,R.raw.papic);
        mPlayer.setVolume(0.2f,0.2f);
        mPlayer.setLooping(true);
        mPlayer.start();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference(USERS_PROFILE_INFO).child(profileId);
        myRef.addListenerForSingleValueEvent(eventListener);
    }


    ValueEventListener eventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if(StringNoNull(dataSnapshot.child(NAME).getValue().toString()))
                goNext(dataSnapshot);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
    @Override
    protected void onStart() {
        super.onStart();
        if (mPlayer!=null) {
            mPlayer.start();
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (mPlayer.isPlaying()) {
            mPlayer.pause();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPlayer.isPlaying()) {
            mPlayer.stop();
        }
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mPlayer.isPlaying()) {
            mPlayer.stop();
        }
    }

}