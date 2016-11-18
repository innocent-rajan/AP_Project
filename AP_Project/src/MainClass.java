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
    	int flag=0;
    System.setProperty("jdk.xml.entityExpansionLimit", "0");
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    try {
        SAXParser saxParser = saxParserFactory.newSAXParser();
        parse handler = new parse();
        System.out.println("Starting.");
        saxParser.parse(new File("dblp.xml"), handler);
        System.out.println("Ending.");
        //Get Employees list
        List<Record> empList = handler.getEmpList();
        //print employee information
        int i=0;
        for(Record rec : empList){
        	//print(rec);
        	if(rec.getTitle().compareTo("The ITIS'98 forums.")==0)
        		flag=1;
        	i++;
        }
        System.out.println("i: "+i);
    } catch (ParserConfigurationException | SAXException | IOException e) {
        e.printStackTrace();
    }
    if(flag==1)
    	System.out.println("Found.");
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