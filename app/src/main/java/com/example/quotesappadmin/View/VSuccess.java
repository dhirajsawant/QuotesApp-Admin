package com.example.quotesappadmin.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.quotesappadmin.Adapter.QuotesAdapter;
import com.example.quotesappadmin.Model.QuotesModel;
import com.example.quotesappadmin.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class VSuccess extends AppCompatActivity {

    ListView listView;
    Query databaseReference;
    List<QuotesModel> list;
    QuotesAdapter quotesAdapter;
    QuotesModel quotesModel;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vsuccess);

        listView = (ListView) findViewById(R.id.v_listview_success);
        list = new ArrayList<>();

        progressBar = findViewById(R.id.pro_success);
        progressBar.setVisibility(View.VISIBLE);

        databaseReference = FirebaseDatabase.getInstance().getReference("quotes").orderByChild("qt_cat").equalTo("Success");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    quotesModel = snap.getValue(QuotesModel.class);
                    list.add(quotesModel);
                }
                quotesAdapter = new QuotesAdapter(VSuccess.this, list);
                listView.setAdapter(quotesAdapter);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
