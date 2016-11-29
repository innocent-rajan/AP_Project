import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Query2 extends DefaultHandler {
		Boolean iswww,isAuthor;
		protected ArrayList<Record> recList = new ArrayList<Record>();
		protected String tmpValue;
		protected Record recTmp;
		private Authors tmpAut;
		protected int i=0;
		protected Query1 q1=new Query1();
		protected ArrayList<www> autList= new ArrayList<www>();
		protected www autTmp;
	    public ArrayList<Record> getRecList() {
	        return recList;
	    }
	    public ArrayList<www> getauthList() {
	        return autList;
	    }
	    private String author_s=new String();
	    private HashMap hash = new HashMap();
	    
	    int a,au,d;
	    
	    public String getAuthor_s() {
			return author_s;
		}
		public void setAuthor_s(String author_s) {
			this.author_s = author_s;
		}
	    
	    @Override
	    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	    	i++;
	    	if (qName.equalsIgnoreCase("article")) {
	        	recTmp=new Record();
	            //recTmp.setJournal(attributes.getValue("journal"));
	        }
	    	if (qName.equalsIgnoreCase("www")) {
	    		autTmp=new www();
	            au=1;
	        }
	    }

	    @Override
	    public void endElement(String uri, String localName, String qName) throws SAXException {
	    	d=0;
	    	if(au==1)
	    	{
	    		if(qName.equalsIgnoreCase("author")){
	    			autTmp.setAuthor(tmpValue);
	    			//System.out.println(autTmp);
			    }
	    	}
	    	if (qName.equalsIgnoreCase("www")) {
    			autList.add(autTmp);
    		}
	    	if(qName.equalsIgnoreCase("author")){ 
	    		a=find_author(tmpValue);
		    }
	    	if (a==1){
	    		isAuthor = true;
	    		iswww = true;
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
	        //System.out.println(i);
	    	if(d==1)
	    		System.out.println(recTmp.toString());
	        //
	    }

	    @Override
	    public void characters(char ch[], int start, int length) throws SAXException {
	    	tmpValue = new String(ch, start, length);
	    	
	    	if(iswww && isAuthor){
	    		if(tmpAut.getMap_val()==-1){
	    			tmpAut.setMap_val(tmpAut.getN());
	    		}
	    	}
	    	hash.put(tmpValue,tmpAut.getMap_val());
	    	isAuthor=false;
	    }
	    
	    int find_author(String author){
	    	if(author_s.equalsIgnoreCase(author)){
	    		return 1;
	    	}
	    	else
	    		return 0;
	    }
}
