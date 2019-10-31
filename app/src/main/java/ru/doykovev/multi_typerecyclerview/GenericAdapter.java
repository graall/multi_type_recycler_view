package ru.doykovev.multi_typerecyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 *  it is necessary to pass to the constructor the implementation of the listner
 *  of the adapter typed by type T, as well as the element markup file in which
 *  it is necessary to implement the databinding mechanism and declare the element
 *  variable typed by adapter type T, name it 'item' and fill out the markup content with it
 *
 * </div>
 */
public class GenericAdapter<T> extends RecyclerView.Adapter<GenericViewHolder> {
    private OnItemClickListener<T> listener;
    private int layoutId;
    private List<T> items = new ArrayList<>();

    public GenericAdapter(OnItemClickListener<T> listener, int layoutId) {
        this.listener = listener;
        this.layoutId = layoutId;
    }

    /**
     *
     * @param items it is date which will show
     */
    public void setData(List<T> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, layoutId, parent, false);
        binding.setVariable(BR.listener, listener);
        return new GenericViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder holder, int position) {
        final T item = items.get(position);
        holder.getBinding().setVariable(BR.item, item);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


}