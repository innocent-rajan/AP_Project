import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Control {
	
	public void parse(){
		System.setProperty("jdk.xml.entityExpansionLimit", "0");
	    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
	    try {
	    	SAXParser saxParser = saxParserFactory.newSAXParser();
	        Query1 handler = new Query1();
	        System.out.println("Starting.");
	        saxParser.parse(new File("dblp.xml"), handler);
	        System.out.println("Ending.");
	        //List<Record> empList = handler.getRecList();
	    } catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	    	System.out.println("Done.");
	    }
	}
	
}
