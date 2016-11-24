//package AP_Project;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class MainClass {

    public static void main(String[] args) {
    System.setProperty("jdk.xml.entityExpansionLimit", "0");
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    try {
    	SAXParser saxParser = saxParserFactory.newSAXParser();
        parse handler = new parse();
        System.out.println("Starting.");
        saxParser.parse(new File("dblp.xml"), handler);
        System.out.println("Ending.");
        List<Record> empList = handler.getRecList();
        int i=0;
        for(Record rec : empList) {
        	System.out.println(rec.toString());
        	i++;
        	if (i==20)
        		break;
        	}
    	} catch (ParserConfigurationException | SAXException | IOException e) {
    		e.printStackTrace();
    	}	
    }

    public static void print(Record rec){
    	System.out.println("Month : " +rec.getMonth());
    	System.out.println("Year : " +rec.getYear());
    	System.out.println("Pages : " +rec.getPages());
    	System.out.println("Title : " +rec.getTitle());
    	System.out.println("Url : " +rec.getUrl());
    	System.out.println("Volume : " +rec.getVolume());
    	System.out.println("Authors : " +rec.getAuthors());
    }
    
}