//package AP_Project;
//@author Rajan Girsa and Avdesh Kumar
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> branch 'master' of https://github.com/innocent-rajan/AP_Project
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class MainClass {
<<<<<<< HEAD
	static Query2 handler = new Query2();
    public static void main(String[] args) {
=======
	static Query1 q1 = new Query1();
	static Query2 q2 = new Query2();
    @SuppressWarnings("resource")
	public static void main(String[] args) {
    	int size=0;
>>>>>>> branch 'master' of https://github.com/innocent-rajan/AP_Project
    	String aut=new String();
    	Scanner user_input = new Scanner( System.in );
    	parseall();
		System.out.print("Enter author : ");
		aut=user_input.nextLine();
<<<<<<< HEAD
		handler.setAuthor_s(aut);
    	ArrayList<Authors> au=handler.getauthList();
    	ArrayList<String> name = new ArrayList<String>();
    	for(Authors Author : au) {
    		for(int i=0;i<Author.getNames().size();++i){
    			if(Author.getNames().get(i).equals(aut)){
    				System.out.println(Author.getNames().size());
    				//System.exit(0);
    			}
    			for(int j=0;j<Author.getNames().size();++j)
    				name.add(Author.getNames().get(j));
    		}
    	}
		/*for(Authors Author : au) {
			for(int i=0;i<Author.getNames().size();++i){
				if(Author.getNames().get(i).equals(aut)){
					System.out.println(Author.getNames().get(i));
					aut=Author.getNames().get(i);
					parseall();
					}
        		}
			}*/
    	for(int index =0;index<name.size();++index)
    		System.out.println(name.get(index));
    	}

    public static void parseall(){
		System.setProperty("jdk.xml.entityExpansionLimit", "0");
=======
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
>>>>>>> branch 'master' of https://github.com/innocent-rajan/AP_Project
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			System.out.println("Starting.");
			saxParser.parse(new File("dblp.xml"), q1);
			System.out.println("Ending.");
    		} catch (ParserConfigurationException | SAXException | IOException e) {
    			e.printStackTrace();
    	}
<<<<<<< HEAD
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
    
=======
    }    
>>>>>>> branch 'master' of https://github.com/innocent-rajan/AP_Project
}