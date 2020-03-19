package com.desafiolatam.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;

import com.desafiolatam.recyclerview.modelo.Animal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AnimalAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private AnimalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.reciclerView);
        adapter = new AnimalAdapter(initializerAnimals(), this, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // grilla
        GridLayoutManager gridLayoutManager;
        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

    }

    private List<Animal> initializerAnimals() {

        Animal animal1 = new Animal("https://images.unsplash.com/photo-1503431128871-cd250803fa41?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80", "gato");
        Animal animal2 = new Animal("https://images.unsplash.com/photo-1463852247062-1bbca38f7805?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1055&q=80", "mono");
        Animal animal3 = new Animal("https://images.unsplash.com/photo-1500479694472-551d1fb6258d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80", "zorro");

        List<Animal> animalList = new ArrayList<Animal>();
        animalList.add(animal1);
        animalList.add(animal2);
        animalList.add(animal3);


        return animalList;
    }

    @Override
    public void onClick(AnimalAdapter.ViewHolder viewHolder, String nameAnimal, String url) {
        Toast.makeText(this, nameAnimal, Toast.LENGTH_SHORT).show();
        instanceDetailFragment(nameAnimal,url);
    }

    private void instanceDetailFragment(String name, String url){
        DetailFragment detailFragment = DetailFragment.newInstance(name,url);
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, detailFragment, "detailFragment").commit();
    }
}

