package info.duhovniy.rxrecycler.model;


public class Item {

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

    public String getHeader() {
        return header;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
