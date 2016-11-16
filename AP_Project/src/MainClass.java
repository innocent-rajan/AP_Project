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
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    try {
        SAXParser saxParser = saxParserFactory.newSAXParser();
        //saxParser.setProperty("SP_GENERAL_ENTITY_SIZE_LIMIT",50000000);
        parse handler = new parse();
        saxParser.parse(new File("dblp.xml"), handler);
        System.out.println("Starting.");
        //Get Employees list
        List<Record> empList = handler.getEmpList();
        //print employee information
        for(Record rec : empList)
            System.out.println(rec);
    } catch (ParserConfigurationException | SAXException | IOException e) {
        e.printStackTrace();
    }
    }

}