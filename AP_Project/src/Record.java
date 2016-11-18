import java.util.ArrayList;
import java.util.HashMap;

public class Record {
	private ArrayList<String> authors = new ArrayList<String>();
	private int year;
	String month;
	private String title;
	private String pages;
	private int volume;
	private String url;
	private HashMap<String,String> Attributes = new HashMap<String,String>();
	
	public ArrayList<String> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String string1) {
		this.month = string1;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public HashMap<String, String> getAttributes() {
		return Attributes;
	}

	public void setAttributes(HashMap<String, String> attributes) {
		Attributes = attributes;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title){
		this.title=title;
	}
	
	public void setyear(int year){
		this.year=year;
	}
	
	public void setmth(String mth){
		this.month=mth;
	}
	
	public void addAuthor(String auth){
		authors.add(auth);
	}
	
	public void addAttr(String attr,String value){
		if(attr.equals("author")){
			this.addAuthor(value);
		}
		else if(attr.equals("title")){
			this.setTitle(value);
		}
		else if(attr.equals("month")){
			this.setmth(value);
		}
		else if(attr.equals("year")){
			this.setyear(Integer.parseInt(value));
		}
		else{
			Attributes.put(attr,value);
		}
	}
	
	@Override
    public String toString() {
        return "Record:: Author="+this.authors+" Title=" + this.title + " Month=" + this.month + " Year=" + this.year +" Url=" + this.url + " Pages"+this.pages+ " Volume"+this.volume;
    }
	
}
