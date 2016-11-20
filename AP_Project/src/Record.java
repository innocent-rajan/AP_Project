import java.util.ArrayList;
import java.util.HashMap;

public class Record {
	private ArrayList<String> authors;
	private int year;
	private String journal;
	private String title;
	private String pages;
	private int volume;
	private String url;
	private String booktitle;
	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	private HashMap<String,String> Attributes = new HashMap<String,String>();
	
	public Record(){
		authors=new ArrayList<String>();
	}
	
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

	public String getJournal() {
		return journal;
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

	public void setVolume(int d) {
		this.volume = d;
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
	
	public void setJournal(String journal){
		this.journal=journal;
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
		else if(attr.equals("journal")){
			this.setJournal(value);
		}
		else if(attr.equals("year")){
			this.setYear(Integer.parseInt(value));
		}
		else{
			Attributes.put(attr,value);
		}
	}
	
	@Override
    public String toString() {
        return "Record:: "+"Authors= "+this.getAuthors()+" Title=" + this.title + " Pages="+this.pages + " Year=" + this.year + " Volume="+this.volume + " Journal/Booktitle=" + this.getJournal()+"/"+this.getBooktitle() +" Url=" + this.url;
    }	
}