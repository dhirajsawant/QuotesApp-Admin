package com.example.quotesappadmin.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.quotesappadmin.Adapter.AboutAdapter;
import com.example.quotesappadmin.Model.AboutModel;
import com.example.quotesappadmin.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AboutView extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;
    List<AboutModel> list;
    AboutAdapter aboutAdapter;
    AboutModel aboutModel;

    private static final String LINE1_KEY = "com.example.firebasecrud.LINE1_";
    private static final String LINE2_KEY = "com.example.firebasecrud.LINE2_";
    private static final String LINE3_KEY = "com.example.firebasecrud.LINE3_";
    private static final String LINE4_KEY = "com.example.firebasecrud.LINE4_";
    private static final String LINE5_KEY = "com.example.firebasecrud.LINE5_";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_view);

        listView = findViewById(R.id.aboutListView1);
        list = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("aboutUs");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    aboutModel = snap.getValue(AboutModel.class);
                    list.add(aboutModel);
                }
                aboutAdapter = new AboutAdapter(AboutView.this, list);
                listView.setAdapter(aboutAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                aboutModel = list.get(position);
                Intent intent = new Intent(AboutView.this, AboutViewData.class);
                intent.putExtra(LINE1_KEY, aboutModel.getLine1());
                intent.putExtra(LINE2_KEY, aboutModel.getLine2());
                intent.putExtra(LINE3_KEY, aboutModel.getLine3());
                intent.putExtra(LINE4_KEY, aboutModel.getLine4());
                intent.putExtra(LINE5_KEY, aboutModel.getLine5());
                startActivity(intent);
            }
        });


    }
}
