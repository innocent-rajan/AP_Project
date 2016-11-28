import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Query1 extends DefaultHandler{
	protected int flag=0;
	protected List<Record> recList = new ArrayList<Record>();
	protected String tmpValue;
	protected Record recTmp;
	protected int i=0;
	protected String aut;
    public List<Record> getRecList() {
        return recList;
    }
	private Record rec=new Record();
	//private parse p=new parse();
	private Control c=new Control();
	
	void find_author(){
		Scanner user_input = new Scanner( System.in );
		System.out.print("Enter author : ");
		aut=user_input.nextLine();
		c.parse();
	}
	
	@Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    	i++;
    	if (qName.equalsIgnoreCase("article")) {
        	recTmp=new Record();
            //recTmp.setJournal(attributes.getValue("journal"));
        }
    }
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("author")) {
			recTmp.getAuthors().add(tmpValue);
        }
		if (rec.getAuthors().equals("Laurent Pierre")){
			flag=1;
		}
		/*if (qName.equalsIgnoreCase("article")) {
            recList.add(recTmp);
        }
    	
        if (qName.equalsIgnoreCase("pages")) {
            recTmp.setPages(tmpValue);
        }
        if (qName.equalsIgnoreCase("title")) {
            recTmp.setTitle(tmpValue);
        }
        if (qName.equalsIgnoreCase("year")) {
            recTmp.setYear(Integer.parseInt(tmpValue));
        }
        if (qName.equalsIgnoreCase("url")) {
            recTmp.setUrl(tmpValue);
        }
        if(qName.equalsIgnoreCase("author")){
           recTmp.getAuthors().add(tmpValue);
        }
        System.out.println(i);*/
        //System.out.println(recTmp.toString());
		System.out.println(i);
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
    	tmpValue = new String(ch, start, length);
    }
	
	
	void find_title(){
			
	}
	
	void sort_relevance(){
		
	}
	
	void sort_year(){
		
	}
	
	void sort_between_year(){
		
	}
}
