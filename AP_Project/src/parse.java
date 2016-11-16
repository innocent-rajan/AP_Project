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
	    
	    boolean bTitle = false;
	    boolean bName = false;
	    boolean bGender = false;
	    boolean bRole = false;

	    @Override
	    public void startElement(String uri, String localName, String qName, Attributes attributes)
	            throws SAXException {

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
	            bName = true;
	            System.out.println("Article");
	        } else if (qName.equalsIgnoreCase("author")) {
	            bTitle = true;
	            System.out.println("Authors");
	        } else if (qName.equalsIgnoreCase("pages")) {
	            bGender = true;
	            System.out.println("Pages");
	        } else if (qName.equalsIgnoreCase("book")) {
	            bRole = true;
	            System.out.println("Book");
	        }
	    }

	    @Override
	    public void endElement(String uri, String localName, String qName) throws SAXException {
	        if (qName.equalsIgnoreCase("record")) {
	            //add record object to list
	            empList.add(rec);
	        }
	    }

	    @Override
	    public void characters(char ch[], int start, int length) throws SAXException {

	        if (bTitle) {
	            //age element, set record age
	            rec.setTitle((new String(ch, start, length)));
	            bTitle = false;
	        }
	    }
}
