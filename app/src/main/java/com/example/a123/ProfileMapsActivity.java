package com.example.a123;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView LatitudeTextView, LongitudeTextView, NameTextView;
    FirebaseDatabase database;
    Location lastLocation;
    PolylineOptions rectOptions = new PolylineOptions();
    Polyline polygon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Init();
        NameTextView.setText(ActiveUser.getName());
    }

    private void Init() {
        LongitudeTextView = findViewById(R.id.LongitudeTextView);
        LatitudeTextView = findViewById(R.id.LatiduteTextView);
        NameTextView = findViewById(R.id.NameTextView);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        try{setMapLocationChange();}
        catch (Exception e){}
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ProfileMapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);

        } else {
            setMapLocationChange();
        }
    }

    @SuppressLint("MissingPermission")
    private void setMapLocationChange() {

        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener(){

            @Override
            public void onMyLocationChange(Location location) {
                if(location!=null)
                {
                    if(database==null)
                        database = FirebaseDatabase.getInstance();

                    String Lat = String.valueOf(location.getLatitude());
                    String Lon = String.valueOf(location.getLongitude());
                    database.getReference(USERS_PROFILE_INFO).child(profileId).child(POSITION_LATITUDE).setValue(Lat);
                    database.getReference(USERS_PROFILE_INFO).child(profileId).child(POSITION_LONGITUDE).setValue(Lon);
                    LatitudeTextView.setText(Lat);
                    LongitudeTextView.setText(Lon);
                    if(lastLocation!=null)
                    {
                        if(polygon!=null)
                            polygon.remove();
                        rectOptions.add(new LatLng(location.getLatitude(),location.getLongitude()));
                        polygon = mMap.addPolyline(rectOptions);
                    }
                    else
                        rectOptions.add(new LatLng(location.getLatitude(),location.getLongitude()));
                    lastLocation = location;
                }
            }
        });
    }

}