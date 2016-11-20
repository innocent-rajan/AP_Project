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
        parsing handler = new parsing();
        System.out.println("Starting.");
        saxParser.parse(new File("dblp.xml"), handler);
        System.out.println("Ending.");
        List<Record> empList = handler.getEmpList();
        int i=0;
        System.out.println(empList.size());
        /*for(Record rec : empList){
        	System.out.println(rec.toString());
        	/*if(rec.getTitle().compareTo("Optimization and Execution Techniques for Queries With Expensive Methods")==0){
        		flag=1;
        		break;
        	}*/
        	/*i++;
        	if (i==20)
        		break;
        }*/
        //System.out.println(empList.get(10).toString());
        //handler.printall_rec();
        //handler.printall_emp();
        //System.out.println("i: "+i);
    } catch (ParserConfigurationException | SAXException | IOException e) {
        e.printStackTrace();
    }
    /*if(flag==1)
    	System.out.println("Found.");
    else
    	System.out.println("Not Found.");*/
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