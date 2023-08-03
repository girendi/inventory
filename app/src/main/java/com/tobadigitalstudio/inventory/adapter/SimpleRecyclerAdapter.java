package com.tobadigitalstudio.inventory.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SimpleRecyclerAdapter<T> extends RecyclerView.Adapter<SimpleRecyclerAdapter.SimpleViewHolder> {

    protected List<T> mainData;
    private SimpleRecyclerAdapter.OnViewHolder<T> listener;
    private @LayoutRes int layoutRes;

    public SimpleRecyclerAdapter(List<T> mainData, int layoutRes, SimpleRecyclerAdapter.OnViewHolder<T> listener) {
        this.mainData = mainData;
        this.listener = listener;
        this.layoutRes = layoutRes;
    }

    public SimpleRecyclerAdapter(int layoutRes, SimpleRecyclerAdapter.OnViewHolder<T> listener) {
        this.layoutRes = layoutRes;
        this.listener = listener;
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        private SimpleRecyclerAdapter.OnViewHolder listener;
        private ViewDataBinding layoutBinding;
        private SimpleRecyclerAdapter adapter;

        public SimpleViewHolder(View itemView, SimpleRecyclerAdapter.OnViewHolder listener, SimpleRecyclerAdapter adapter) {
            super(itemView);

            try {
                this.listener = listener;
                this.adapter = adapter;
                layoutBinding = DataBindingUtil.bind(itemView);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        public SimpleViewHolder(View itemView, SimpleRecyclerAdapter.OnViewHolder listener) {
            this (itemView, listener, null);
        }

        public ViewDataBinding getLayoutBinding() {
            return layoutBinding;
        }

        public SimpleRecyclerAdapter getAdapter () {
            return adapter;
        }
    }

    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutRes(), parent, false);
        return new SimpleViewHolder(view, getListener(), this);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        T t = mainData.get(position);
        getListener().onBindView(holder, t);
    }

    @Override
    public int getItemCount() {
        return mainData == null ? 0 : mainData.size();
    }

    public List<T> getMainData() {
        return mainData;
    }

    public void setMainData(List<T> mainData) {
        this.mainData = mainData;
        notifyDataSetChanged();
    }

    public SimpleRecyclerAdapter.OnViewHolder<T> getListener() {
        return listener;
    }

    public void setListener(SimpleRecyclerAdapter.OnViewHolder<T> listener) {
        this.listener = listener;
    }

    public int getLayoutRes() {
        return layoutRes;
    }

    public void setLayoutRes(int layoutRes) {
        this.layoutRes = layoutRes;
    }

    public interface OnViewHolder<T> {
        void onBindView(SimpleViewHolder holder, T item);
    }
}
