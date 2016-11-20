import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class parsing extends DefaultHandler {
	
	public List<Record> recList;
	Record rec;
	String tmpVal;
	public List<Record> getEmpList() {
		return recList;
	}
	
	void printall_rec(){
		System.out.println("recList");
		int i=0;
		for(int j=0;j<=recList.size();++j){
			System.out.println(recList.get(j).toString());
			if (j==20)
				break;
		}
		System.out.println("recList1");
		for(Record rec : recList){
			System.out.println(rec.toString());
			if (i==20)
				break;
			i++;
		}
	}
	
	void printall_emp(){
		System.out.println("empList");
		int i=0;
		List<Record> empList= getEmpList();
		for(Record rec : empList){
			System.out.println(rec.toString());
			if (i==20)
				break;
			i++;
		}
	}
	
	public parsing(){
		recList = new ArrayList<Record>();
	}
	
	boolean bTitle = false;
	boolean bPages = false;
	
	public void startElement(String uri, String localName,String qName,Attributes attributes) throws SAXException {
		//System.out.println("Start Element :" + qName);
		if (qName.equalsIgnoreCase("dblp")) {
			rec=new Record();
		}
		if (qName.equalsIgnoreCase("pages")) {
			System.out.println("title");
			rec.setTitle(attributes.getValue("title"));
			//System.out.println("article");
			String id =attributes.getValue("title");
			//System.out.println("volume");
			//System.out.println("Volume : "+id);
		}
        if (qName.equalsIgnoreCase("inproceedings")) {
            System.out.println("inproceedings");
            rec.setBooktitle(attributes.getValue("booktitle"));
			String id = attributes.getValue("booktitle");
			//System.out.println("booktitle : "+id);
        }
	}
	
	public void endElement(String uri, String localName,String qName) throws SAXException {
		//System.out.println("End Element :" + qName);
		if (qName.equalsIgnoreCase("article")) {
			//System.out.println("Title : " + rec.getTitle());
            recList.add(rec);
            int l = recList.size();
            //System.out.println(recList.size());
            //System.out.println(recList.get(l-1).toString());
            //System.out.println(rec.toString());
            //System.out.println("Title : " + rec.getTitle());
        }
		if (qName.equalsIgnoreCase("title")) {
			rec.setTitle(tmpVal);
			//System.out.println("Title : " + rec.getTitle());
		}
		if (qName.equalsIgnoreCase("Pages")) {
			rec.setPages(tmpVal);
			//System.out.println("Pages : " + rec.getPages());
			//bPages = true;
		}		
	}
	
	public void characters(char ch[], int start, int length) throws SAXException {
		tmpVal=new String(ch, start, length);
		//System.out.println("tmpVal : " +tmpVal);
		/*if (bTitle) {
			//System.out.println("Title : " + new String(ch, start, length));
			tmpVal=new String(ch, start, length);
			bTitle = false;
		}
		
		if (bPages) {
			//System.out.println("Pages : " + new String(ch, start, length));
			tmpVal=new String(ch, start, length);
			bPages = false;
		}*/
	}
}
