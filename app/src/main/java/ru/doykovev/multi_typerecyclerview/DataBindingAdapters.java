package ru.doykovev.multi_typerecyclerview;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public final class DataBindingAdapters {
    @BindingAdapter("rv_items")
    public static void setRecyclerViewProperties(RecyclerView recyclerView, List<Item> items) {
        if (recyclerView.getAdapter() instanceof GenericAdapter) {
            ((GenericAdapter<Item>) recyclerView.getAdapter()).setData(items);
        }
    }

}
