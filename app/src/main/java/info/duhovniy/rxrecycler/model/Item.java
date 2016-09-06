package info.duhovniy.rxrecycler.model;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import info.duhovniy.rxrecycler.BR;

public class Item extends BaseObservable {

    private long id;
    private String header;
    private String description;
    private String image;

    public Item(long id, String header, String description, String image) {
        setId(id);
        setHeader(header);
        setDescription(description);
        setImage(image);
    }

    public long getId() {
        return id;
    }

    @Bindable
    public String getHeader() {
        return header;
    }

    @Bindable
    public String getImage() {
        return image;
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setHeader(String header) {
        this.header = header;
        notifyPropertyChanged(BR.header);
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    public void setImage(String image) {
        this.image = image;
        notifyPropertyChanged(BR.image);
    }
}
