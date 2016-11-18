import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class parse extends DefaultHandler {
	 private List<Record> empList = null;
	    private Record rec = null;


	    //getter method for Record list
	    public List<Record> getEmpList() {
	        return empList;
	    }

	    boolean bAuthors = false;
	    boolean bYear = false;
	    boolean bMonth = false;
	    boolean bTitle = false;
	    boolean bPages = false;
	    boolean bVol = false;
	    boolean bUrl = false;
        boolean bArticle = false;

	    @Override
	    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	    	//System.out.println("start element    : " + qName);
	        if (qName.equalsIgnoreCase("dblp")) {
	            //create a new record and put it in Map
	            String id = attributes.getValue("id");
	            //initialize record object and set id attribute
	            rec = new Record();
	            //initialize list
	            if (empList == null)
	                empList = new ArrayList<>();
	        } else if (qName.equalsIgnoreCase("article")) {
	            //set boolean values for fields, will be used in setting record variables
	            bArticle = true;
	           // System.out.println("Article");
	        } else if (qName.equalsIgnoreCase("author")) {
	            bAuthors = true;
	          //  System.out.println("Authors");
	        } else if (qName.equalsIgnoreCase("pages")) {
	            bPages = true;
	          //  System.out.println("Pages");
	        } else if (qName.equalsIgnoreCase("year")) {
	            bYear = true;
	         //   System.out.println("Year");
	        }
	        else if (qName.equalsIgnoreCase("month")) {
	            bMonth = true;
	         //   System.out.println("Month");
	        }
	        else if (qName.equalsIgnoreCase("Vol")) {
	            bVol = true;
	          //  System.out.println("Vol");
	        }
	        else if (qName.equalsIgnoreCase("url")) {
	            bUrl = true;
	          //  System.out.println("Url");
	        }
	        else if (qName.equalsIgnoreCase("Title")) {
	            bTitle = true;
	            //rec.setTitle(qName);
	        }
	    }

	    @Override
	    public void endElement(String uri, String localName, String qName) throws SAXException {
	    	//System.out.println("end element    : " + qName);
	        if (qName.equalsIgnoreCase("article")) {
	            //add record object to list
	            empList.add(rec);
	        }
	    	//System.out.println("Size : "+empList.size());
	    }

	    @Override
	    public void characters(char ch[], int start, int length) throws SAXException {
	    	//System.out.println("start characters : " + new String(ch, start, length));
	        if (bPages) {
	            //age element, set record age
	            rec.setPages(new String(ch, start, length));
	            bPages = false;
	        }
	        else if(bYear){
	        	rec.setYear(Integer.parseInt(new String(ch, start, length)));
	            bYear=false;
	        }
	        else if(bVol){
	        	rec.setVolume(Integer.parseInt(new String(ch, start, length)));
	            bVol=false;
	        }
	        else if(bTitle){
	        	rec.setTitle(new String(ch, start, length));
	            bTitle=false;
	        }
	        else if(bMonth){
	        	rec.setMonth(new String(ch, start, length));
	            bMonth=false;
	        }
	        else if(bUrl){
	        	rec.setUrl(new String(ch, start, length));
	            bUrl=false;
	        }
	    }
}
