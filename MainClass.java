//package AP_Project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class MainClass {
	static Query1 handler = new Query1();
    public static void main(String[] args) {
    	int size=0;
    	String aut=new String();
    	Scanner user_input = new Scanner( System.in );
    	parseall();
		System.out.print("Enter author : ");
		aut=user_input.nextLine();
    	ArrayList<Authors> au=handler.getauthList();
    	ArrayList<String> name = new ArrayList<String>();
    	for(Authors Author : au) {
    		for(int i=0;i<Author.getNames().size();++i){
    			if(Author.getNames().get(i).equals(aut)){
    				size=Author.getNames().size();
    				for(int j=0;j<size;++j)
        				name.add(Author.getNames().get(j));
    			}
    		}
    	}
    	handler.setAuthor_s(name);
    	parseall();
		/*for(Authors Author : au) {
			for(int i=0;i<Author.getNames().size();++i){
				if(Author.getNames().get(i).equals(aut)){
					System.out.println(Author.getNames().get(i));
					aut=Author.getNames().get(i);
					parseall();
					}
        		}
			}*/
    	}

    public static void parseall(){
		System.setProperty("jdk.xml.entityExpansionLimit", "0");
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			System.out.println("Starting.");
			saxParser.parse(new File("dblp.xml"), handler);
			System.out.println("Ending.");
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