package info.duhovniy.rxrecycler;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import info.duhovniy.rxrecycler.databinding.ListItemBinding;
import info.duhovniy.rxrecycler.model.Item;

/**
 * Created by nickelAdmin on 05/09/2016.
 */
public class ReAdapter extends RecyclerView.Adapter<ReAdapter.ViewHolder> {

    private List<Item> items;

    public ReAdapter() {
        items = Collections.emptyList();
    }

    public ReAdapter(List<Item> list) {
        items = list;
    }

    public void addItem(Item item) {
        items.add(item);
        notifyDataSetChanged();
    }

    @Override
    public ReAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemBinding binding = (ListItemBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.list_item,
                parent,
                false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ReAdapter.ViewHolder holder, int position) {
        holder.binding.setItem(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String imageUrl) {
        Picasso.with(imageView.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.placeholder)
                .into(imageView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ListItemBinding binding;

        public ViewHolder(ListItemBinding binding) {
            super(binding.cardView);
            this.binding = binding;
        }


    }
}
