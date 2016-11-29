import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Query1 extends DefaultHandler {
		Boolean iswww=false,isAuthor=false;
		private ArrayList<Record> recList = new ArrayList<Record>();
		private String tmpValue;
		private Record recTmp;
		private Authors tmpAut;
		private int found=0;
		private ArrayList<Authors> autList= new ArrayList<Authors>();
	    public ArrayList<Record> getRecList() {
	        return recList;
	    }
	    public ArrayList<Authors> getauthList() {
	        return autList;
	    }
	    private ArrayList<String> author_s=new ArrayList<String>();
	    
	    int a,au,d;
	    
	    public ArrayList<String> getAuthor_s() {
			return author_s;
		}
		public void setAuthor_s(ArrayList<String> author) {
			this.author_s = author;
		}
	    
	    @Override
	    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	    	if (qName.equalsIgnoreCase("article")) {
	        	recTmp=new Record();
	        }
	    	if (qName.equalsIgnoreCase("www")) {
	    		tmpAut=new Authors();
	            au=1;
	        }
	    }

	    @Override
	    public void endElement(String uri, String localName, String qName) throws SAXException {
	    	d=0;
	    	if(au==1)
	    	{
	    		if(qName.equalsIgnoreCase("author")){
	    			tmpAut.setNames(tmpValue);
	    			iswww = true;
	    			isAuthor = true;
			    }
	    	}
	    	if (qName.equalsIgnoreCase("www")) {
    			autList.add(tmpAut);
    		}
	    	if(qName.equalsIgnoreCase("author")){ 
	    		//author_s = ;
	    		find_author(tmpValue);
		    }
	    	if (found==1){
	    		if(qName.equalsIgnoreCase("author")){
	    			recTmp.addAuthor(tmpValue);
	    		}
	    		if (qName.equalsIgnoreCase("article")) {
	    			recList.add(recTmp);
	    		}
	    		if (qName.equalsIgnoreCase("journal")) {
	    			recTmp.setJournal(tmpValue);
	    		}
	    		if (qName.equalsIgnoreCase("pages")) {
	    			recTmp.setPages(tmpValue);
	    		}
	    		if (qName.equalsIgnoreCase("title")) {
	    			recTmp.setTitle(tmpValue);
	    		}
	    		if (qName.equalsIgnoreCase("year")) {
	    			recTmp.setYear(Integer.parseInt(tmpValue));
	    		}
	    		if (qName.equalsIgnoreCase("url")) {
	    			recTmp.setUrl(tmpValue);
	    			d=1;
	    		}
	    	}
	    	if(d==1)
	    		System.out.println(recTmp.toString());
	    }

	    @Override
	    public void characters(char ch[], int start, int length) throws SAXException {
	    	tmpValue = new String(ch, start, length);
	    }
	    
	    void find_author(String author){
	    	found=0;
	    	for(int i=0;i<author_s.size();++i){
	    		if(author_s.get(i).equalsIgnoreCase(author)){
	    			found=1;
	    		}
	    	}
	    }
}
