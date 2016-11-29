import java.util.ArrayList;

public class www {
	private String author = new String();

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String aut) {
		this.author = aut;
	}
	
	@Override
	public String toString(){
		return "Authors : "+this.getAuthor();
		
	}
}
