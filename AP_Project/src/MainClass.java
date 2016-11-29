//package AP_Project;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class MainClass {

    public static void main(String[] args) {
    	String aut=new String();
    	Scanner user_input = new Scanner( System.in );
		System.out.print("Enter author : ");
		aut=user_input.nextLine();
		parse handler = new parse();
		handler.setAuthor_s(aut);
		System.setProperty("jdk.xml.entityExpansionLimit", "0");
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			System.out.println("Starting.");
			saxParser.parse(new File("dblp.xml"), handler);
			System.out.println("Ending.");
        //List<Record> empList = handler.getRecList();
        /*List<www> empList = handler.getauthList();
        int i=0;
        for(www www : empList) {
        	System.out.println(www.toString());
        	i++;
        	if (i==100)
        		break;
        	}*/
    		} catch (ParserConfigurationException | SAXException | IOException e) {
    			e.printStackTrace();
    		}	
    	}

    /*public static void print(Record rec){
    	//System.out.println("Month : " +rec.getMonth());
    	System.out.println("Year : " +rec.getYear());
    	System.out.println("Pages : " +rec.getPages());
    	System.out.println("Title : " +rec.getTitle());
    	System.out.println("Url : " +rec.getUrl());
    	System.out.println("Volume : " +rec.getVolume());
    	System.out.println("Authors : " +rec.getAuthors());
    }*/
    
}