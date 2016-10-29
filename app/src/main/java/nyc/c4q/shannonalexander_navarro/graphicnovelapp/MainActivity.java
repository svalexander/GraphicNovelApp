package nyc.c4q.shannonalexander_navarro.graphicnovelapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Novel> novels;
    String title;
    ArrayList<String> listOfNovels;

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewID);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        listOfNovels= new ArrayList<>();

        listOfNovels.add("Love and Rockets: Music for Mechanics");
        listOfNovels.add("Summer of Love");
        listOfNovels.add("99 Ways to Tell to a Story");
        listOfNovels.add("A Child's Life");
        listOfNovels.add("Oulipo Compendium");

        novels = new ArrayList<>();

        for(int i = 0; i < listOfNovels.size(); i++){
            title = listOfNovels.get(i);
            Log.d("title",title);
            novels.add(new Novel(title));
        }
        //Log.d("title",title);
        initializeAdapter();
    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(novels);
        recyclerView.setAdapter(adapter);
    }
}
