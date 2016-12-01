//package AP_Project;
//@author Rajan Girsa and Avdesh Kumar
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class MainClass {
	static parse p = new parse();
	static Query1 q1 = new Query1();
	static Query2 q2 = new Query2();
    @SuppressWarnings("resource")
	public static void main(String[] args) {
    	int size=0;
    	String aut=new String();
    	Scanner user_input = new Scanner( System.in );
    	parseall();
		System.out.print("Enter author : ");
		aut=user_input.nextLine();
    	ArrayList<Authors> au=p.getauthList();
    	ArrayList<String> name = new ArrayList<String>();
    	for(Authors Author : au) {
    		//System.out.println(Author.getNames());
    		for(int i=0;i<Author.getNames().size();++i){
    			if(Author.getNames().get(i).equals(aut)){
    				size=Author.getNames().size();
    				for(int j=0;j<size;++j)
        				name.add(Author.getNames().get(j));
    			}
    		}
    	}
    	q1.setAuthor_s(name);
    	ArrayList<String> tags=new ArrayList<String>();
    	System.out.print("Enter Title : ");
		String title=user_input.nextLine();
		String[] arr = title.split(" ");    
		for (String ss : arr) {
				tags.add(ss);
			}
			tags.add(title);
		q1.setTitle_n(tags);
    	System.setProperty("jdk.xml.entityExpansionLimit", "0");
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			System.out.println("Starting.");
			saxParser.parse(new File("dblp.xml"), q1);
			System.out.println("Ending.");
    		} catch (ParserConfigurationException | SAXException | IOException e) {
    			e.printStackTrace();
    		}
    	q1.sort();
    	}

    public static void parseall(){
    	System.setProperty("jdk.xml.entityExpansionLimit", "0");
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			System.out.println("Starting.");
			saxParser.parse(new File("dblp.xml"), p);
			System.out.println("Ending.");
    		} catch (ParserConfigurationException | SAXException | IOException e) {
    			e.printStackTrace();
    	}
    }    
}