import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class test extends DefaultHandler {
    List<Record> recL;
    String recXmlFileName;
    String tmpValue;
    Record recTmp;
    SimpleDateFormat sdf= new SimpleDateFormat("yy-MM-dd");
    public test(String recXmlFileName) {
        this.recXmlFileName = recXmlFileName;
        recL = new ArrayList<Record>();
        parseDocument();
        printDatas();
    }
    private void parseDocument() {
    	System.setProperty("jdk.xml.entityExpansionLimit", "0");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            //parsing handler = new parsing();
            System.out.println("Starting.");
            saxParser.parse(new File("dblp.xml"), this);
            System.out.println("Ending.");
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfig error");
        } catch (SAXException e) {
            System.out.println("SAXException : xml not well formed");
        } catch (IOException e) {
            System.out.println("IO error");
        }
    }
    private void printDatas() {
       // System.out.println(recL.size());
        for (Record tmpB : recL) {
            System.out.println(tmpB.toString());
        }
    }
    @Override
    public void startElement(String s, String s1, String elementName, Attributes attributes) throws SAXException {
        // if current element is rec , create new rec
        // clear tmpValue on start of element
        /*if (elementName.equalsIgnoreCase("dblp")) {
            
        }*/
        if (elementName.equalsIgnoreCase("article")) {
        	recTmp=new Record();
            recTmp.setTitle(attributes.getValue("title"));
        }
        if (elementName.equalsIgnoreCase("inproceedings")) {
            recTmp.setBooktitle(attributes.getValue("booktitle"));
        }
    }
    @Override
    public void endElement(String s, String s1, String element) throws SAXException {
        // if end of rec element add to list
        if (element.equals("article")) {
            recL.add(recTmp);
        }
        if (element.equalsIgnoreCase("pages")) {
            recTmp.setPages(tmpValue);
        }
        if (element.equalsIgnoreCase("title")) {
            recTmp.setTitle(tmpValue);
        }
        if(element.equalsIgnoreCase("author")){
           recTmp.getAuthors().add(tmpValue);
        }
    }
    @Override
    public void characters(char[] ac, int i, int j) throws SAXException {
        tmpValue = new String(ac, i, j);
    }
    public static void main(String[] args) {
        new test("dblp.xml");
    }
}