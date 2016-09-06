package info.duhovniy.rxrecycler.model;


import android.databinding.BaseObservable;

public class Item extends BaseObservable {

    public long id;
    public String header;
    public String description;
    public String image;

    public Item(long id, String header, String description, String image) {
        this.id = id;
        this.header = header;
        this.description = description;
        this.image = image;
    }

}
