package ru.doykovev.multi_typerecyclerview;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

class GenericViewHolder<V extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private V binding;

    GenericViewHolder(V binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    V getBinding() {
        return binding;
    }

}
