import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Book {
    String lang;
    String title;
    String id;
    String isbn;
    Date regDate;
    String publisher;
    int price;
    List<String> authors;
    public Book(){
        authors=new ArrayList<String>();
    }
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(java.util.Date date) {
		this.regDate = date;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
    @Override
    public String toString(){
    	return "Book:: Isbn="+this.isbn+" Title=" + this.title + " Author=" + this.authors + " Pricce=" + this.price +
                " RegDate=" + this.regDate;
    	
    }
}