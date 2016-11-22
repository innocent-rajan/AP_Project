import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class parse extends DefaultHandler {
		private List<Record> recList = new ArrayList<Record>();
		private String tmpValue;
		private Record recTmp;
		//int i=0;
	    public List<Record> getRecList() {
	        return recList;
	    }

	    @Override
	    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	    	//i++;
	    	if (qName.equalsIgnoreCase("article")) {
	        	recTmp=new Record();
	            //recTmp.setVolume(Integer.parseInt(attributes.getValue("volume")));
	            recTmp.setJournal(attributes.getValue("journal"));
	            //System.out.println(attributes.getValue("journal"));
	        }
	        if (qName.equalsIgnoreCase("inproceedings")) {
	        	//recTmp=new Record();
	            recTmp.setBooktitle(attributes.getValue("booktitle"));
	        }
	    }

	    @Override
	    public void endElement(String uri, String localName, String qName) throws SAXException {
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
	        if(qName.equalsIgnoreCase("author")){
	           recTmp.getAuthors().add(tmpValue);
	        }
	        //System.out.println(recTmp.toString());
	    }

	    @Override
	    public void characters(char ch[], int start, int length) throws SAXException {
	    	tmpValue = new String(ch, start, length);
	    }
}
