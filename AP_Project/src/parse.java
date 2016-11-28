import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class parse extends DefaultHandler {
		protected List<Record> recList = new ArrayList<Record>();
		protected String tmpValue;
		protected Record recTmp;
		protected int i=0;
		protected Query1 q1=new Query1();
	    public List<Record> getRecList() {
	        return recList;
	    }

	    @Override
	    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	    	i++;
	    	if (qName.equalsIgnoreCase("article")) {
	        	recTmp=new Record();
	            recTmp.setJournal(attributes.getValue("journal"));
	        }
	        if (qName.equalsIgnoreCase("inproceedings")) {
	            recTmp.setBooktitle(attributes.getValue("booktitle"));
	        }
	    }

	    @Override
	    public void endElement(String uri, String localName, String qName) throws SAXException {
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
	        for (int i=0;i<recTmp.getAuthors().size();++i){
	        	System.out.println("Entering");
	    		String aut = recTmp.getAuthors().get(i);
	    		System.out.println(aut);
	    		if(aut.equals("Millist W. Vincent")){
	    		//if (recTmp.getAuthors().equals("Millist W. Vincent")){
	    			System.out.println("Found.");
	    			System.out.println(recTmp.toString());
	    			System.exit(0);
	    			break;
	    		}
	        }
	        System.out.println(i);
	        System.out.println(recTmp.toString());
	        //
	    }

	    @Override
	    public void characters(char ch[], int start, int length) throws SAXException {
	    	tmpValue = new String(ch, start, length);
	    }
}
