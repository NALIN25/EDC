package com.example.everydropcounts;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

import static com.example.everydropcounts.Splash.database;

public class DonorList extends AppCompatActivity {
    String city;
    String group;
    ArrayList<String> donorList;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    public static ArrayList<Donor> donorInfo;
    Button buttonMap;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_donor_form);

        Bundle extras = getIntent();
        city = extras.getString("city");
        group = extras.getString("group");
        Log.i("NAME",city);
        Log.i("NAME",group);

        donorList = new ArrayList<>();
        donorInfo = new ArrayList<>();
        listView = (ListView) listView.findViewById(R.id.list_donor);
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (getActivity(),
                android.R.layout.simple_spinner_item, donorList);




        DatabaseReference myRef = database.getReference("EDCb");
        myRef.child(city).child(group).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Donor donor = dataSnapshot.getValue(Donor.class);
                donorInfo.add(donor);
                String donorInfo = donor.name + "   \n" + donor.contactNumber;
                donorList.add(donorInfo);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private Context getActivity() {
        return null;
    }

    private void setContentView(int activity_donor_list) {
    }

    private Bundle getIntent() {
        return null;
    }

}
