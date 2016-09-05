package info.duhovniy.rxrecycler;

import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

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
        for (int i = 1; i < 100; i++)
            items.add(new Item(i, "Header " + i, "Loooooooooong commmmmmmment for item " + i,
                    "http://static.planetminecraft.com/files/avatar/62767.gif"));
        return items;
    }

    private void setUpRecyclerView(RecyclerView recyclerView) {
        ReAdapter adapter = new ReAdapter(generateList());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        binding.activityMainSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                adapter.notifyDataSetChanged();
//                binding.activityMainSwipeRefreshLayout.setRefreshing(false);
//            }
//        });
    }
}
