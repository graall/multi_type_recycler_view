package ru.doykovev.multi_typerecyclerview;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import java.util.ArrayList;
import java.util.List;

import ru.doykovev.multi_typerecyclerview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements OnItemClickListener<Item> {

    private static final int MAX_ITEMS = 150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setAdapter(new GenericAdapter<Item>(this, R.layout.item));
        binding.getAdapter().setData(getItems());
    }

    private List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < MAX_ITEMS; i++)
            items.add(new Item(String.format("This is item №%s", i)));
        return items;
    }


    @Override
    public void onItemClick(Item item) {
        Toast.makeText(this, "click on " + item.getName(), Toast.LENGTH_LONG).show();
    }
}
