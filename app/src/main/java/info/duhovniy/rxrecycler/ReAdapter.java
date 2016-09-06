package info.duhovniy.rxrecycler;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
public class ReAdapter extends RecyclerView.Adapter<ReAdapter.ItemViewHolder> {

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
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemBinding binding = ListItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false);
        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.binding.setItem(items.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ListItemBinding binding;

        public ItemViewHolder(ListItemBinding binding) {
            super(binding.cardView);
            this.binding = binding;
        }
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView infoImage, String image) {
        try {
            Picasso.with(infoImage.getContext())
                    .load(image)
                    .resize(100, 100)
                    .placeholder(R.drawable.placeholder)
                    .into(infoImage);
        } catch (Exception e) {
            Log.e("Picasso error", e.getMessage());
        }
    }
}
