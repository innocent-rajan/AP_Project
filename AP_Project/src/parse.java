import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class parse extends DefaultHandler {
		protected ArrayList<Record> recList = new ArrayList<Record>();
		protected String tmpValue;
		protected Record recTmp;
		protected int i=0;
		protected Query1 q1=new Query1();
		protected ArrayList<String> auth=new ArrayList<String>();
	    public List<Record> getRecList() {
	        return recList;
	    }

	    @Override
	    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	    	i++;
	    	if (qName.equalsIgnoreCase("article")) {
	        	recTmp=new Record();
	            //recTmp.setJournal(attributes.getValue("journal"));
	        }
	        /*if (qName.equalsIgnoreCase("inproceedings")) {
	            //recTmp.setBooktitle(attributes.getValue("booktitle"));
	        }*/
	    	if (qName.equalsIgnoreCase("www")) {
	            
	        }
	    }

	    @Override
	    public void endElement(String uri, String localName, String qName) throws SAXException {
	    	int a=0;  
	    	/*if(qName.equalsIgnoreCase("author")){ 
	    		a=find_author(tmpValue);
		    }
	    	if (a==1){
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
	    		}
	    	}*/
	        System.out.println(i);
	        //System.out.println(recTmp.toString());
	        //
	    }

	    @Override
	    public void characters(char ch[], int start, int length) throws SAXException {
	    	tmpValue = new String(ch, start, length);
	    }
	    
	    int find_author(String author){
	    	
	    	return 0;
	    }
}
