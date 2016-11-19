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
    List<Book> bookL;
    String bookXmlFileName;
    String tmpValue;
    Book bookTmp;
    SimpleDateFormat sdf= new SimpleDateFormat("yy-MM-dd");
    public test(String bookXmlFileName) {
        this.bookXmlFileName = bookXmlFileName;
        bookL = new ArrayList<Book>();
        parseDocument();
        printDatas();
    }
    private void parseDocument() {
        // parse
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(bookXmlFileName, this);
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfig error");
        } catch (SAXException e) {
            System.out.println("SAXException : xml not well formed");
        } catch (IOException e) {
            System.out.println("IO error");
        }
    }
    private void printDatas() {
       // System.out.println(bookL.size());
        for (Book tmpB : bookL) {
            System.out.println(tmpB.toString());
        }
    }
    @Override
    public void startElement(String s, String s1, String elementName, Attributes attributes) throws SAXException {
        // if current element is book , create new book
        // clear tmpValue on start of element

        if (elementName.equalsIgnoreCase("book")) {
            bookTmp = new Book();
            bookTmp.setId(attributes.getValue("id"));
            bookTmp.setLang(attributes.getValue("lang"));
        }
        // if current element is publisher
        if (elementName.equalsIgnoreCase("publisher")) {
            bookTmp.setPublisher(attributes.getValue("country"));
        }
    }
    @Override
    public void endElement(String s, String s1, String element) throws SAXException {
        // if end of book element add to list
        if (element.equals("book")) {
            bookL.add(bookTmp);
        }
        if (element.equalsIgnoreCase("isbn")) {
            bookTmp.setIsbn(tmpValue);
        }
        if (element.equalsIgnoreCase("title")) {
            bookTmp.setTitle(tmpValue);
        }
        if(element.equalsIgnoreCase("author")){
           bookTmp.getAuthors().add(tmpValue);
        }
        if(element.equalsIgnoreCase("price")){
            bookTmp.setPrice(Integer.parseInt(tmpValue));
        }
        if(element.equalsIgnoreCase("regDate")){
            try {
                bookTmp.setRegDate(sdf.parse(tmpValue));
            } catch (ParseException e) {
                System.out.println("date parsing error");
            }
        }
    }
    @Override
    public void characters(char[] ac, int i, int j) throws SAXException {
        tmpValue = new String(ac, i, j);
    }
    public static void main(String[] args) {
        new test("catalog.xml");
    }
}