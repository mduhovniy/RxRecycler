package info.duhovniy.rxrecycler.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import info.duhovniy.rxrecycler.R;
import info.duhovniy.rxrecycler.ReAdapter;
import info.duhovniy.rxrecycler.databinding.ActivityMainBinding;
import info.duhovniy.rxrecycler.model.Item;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setUpRecyclerView(binding.recyclerList);
    }

    private List<Item> generateList() {
        List<Item> items = new ArrayList<>();
        String tempDescription = "Loooooooooong commmmmmmment for this item";
        String tempUrl = "http://www.androidfreeware.net/img2/pokmon-go.png";
        for (int i = 1; i < 100; i++) {
            if (i % 4 == 0)
                items.add(new Item(i, "Header " + i, null, null));
            else
                items.add(new Item(i, "Header " + i, tempDescription, tempUrl));
        }
        return items;
    }

    private void setUpRecyclerView(RecyclerView recyclerView) {
        ReAdapter adapter = new ReAdapter(generateList());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
