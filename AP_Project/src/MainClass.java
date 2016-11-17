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
        //saxParser.setProperty("SP_GENERAL_ENTITY_SIZE_LIMIT",50000000);
        parse handler = new parse();
        System.out.println("Starting.");
        saxParser.parse(new File("dblp.xml"), handler);
        System.out.println("Ending.");
        //Get Employees list
        List<Record> empList = handler.getEmpList();
        //print employee information
        int i=0;
        for(Record rec : empList){
        	
        	i++;
        	System.out.println(rec.getTitle());
        }
        System.out.println(i);
    } catch (ParserConfigurationException | SAXException | IOException e) {
        e.printStackTrace();
    }
    }

}