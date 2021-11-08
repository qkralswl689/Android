package org.techtown.listviewinbutton3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an ArrayList of Dessert objects
        ArrayList<Dessert> desserts = new ArrayList<Dessert>();

        desserts.add(new Dessert("Donut", 0, R.drawable.doughnut));
        desserts.add(new Dessert("Cookie", 0, R.drawable.cookie));
        desserts.add(new Dessert("PieceOfCake", 0, R.drawable.piece_of_cake));
        desserts.add(new Dessert("Pastry", 0, R.drawable.pastry));

        // Create an {@link DessertAdapter}, whose data source is a list of
        // {@link Dessert}s. The adapter knows how to create list item views for each item
        // in the list.
        DessertAdapter flavorAdapter = new DessertAdapter(this, desserts);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_dessert);
        listView.setAdapter(flavorAdapter);
    }
    }
}