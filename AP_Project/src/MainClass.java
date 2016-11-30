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
    	ArrayList<Authors> au=q1.getauthList();
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
    	System.out.print("Enter Title : ");
    	String title=user_input.nextLine();
    	q1.setTitle(title);
    	q1.setAuthor_s(name);
    	parseall();
    	q1.sort();
    	/*int size=0;
    	String aut=new String();
    	aut=null;
    	parseall();
    	q2.make_hash();
       	//q1.setAuthor_s(name);
    	//parseall();*/
    	}

    public static void parseall(){
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
    }    
}