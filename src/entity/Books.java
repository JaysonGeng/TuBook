package entity;

public class Books {

    private int Id;
    private String BookName;
    private String Author;
    private String PublishingHouse;
    private String Price;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getPublishingHouse() {
        return PublishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        PublishingHouse = publishingHouse;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
