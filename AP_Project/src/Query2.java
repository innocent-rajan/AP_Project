import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Query2 extends DefaultHandler {
		Boolean iswww=false,isAuthor=false;
		private ArrayList<Record> recList = new ArrayList<Record>();
		private String tmpValue;
		private Record recTmp;
		private Authors tmpAut;
		private int i=0,found=0;;
		private ArrayList<String> name= new ArrayList<String>();
		private ArrayList<Authors> autList= new ArrayList<Authors>();
	    public ArrayList<Record> getRecList() {
	        return recList;
	    }
	    public ArrayList<Authors> getauthList() {
	        return autList;
	    }
	    private ArrayList<String> author_s=new ArrayList<String>();
	    private HashMap hash = new HashMap();
	    
	    int a,au,d;
	    
	    public ArrayList<String> getAuthor_s() {
			return author_s;
		}
		public void setAuthor_s(ArrayList<String> author) {
			this.author_s = author;
		}
	    
	    @Override
	    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	    	i++;
	    	if (qName.equalsIgnoreCase("article")) {
	        	recTmp=new Record();
	            //recTmp.setJournal(attributes.getValue("journal"));
	        }
	    	if ((qName.equalsIgnoreCase("www")) && (attributes.getValue("key").contains("homepages/"))){
	    		tmpAut=new Authors();
	    		iswww = true;
	            au=1;
	        }
	    }

	    @Override
	    public void endElement(String uri, String localName, String qName) throws SAXException {
	    	d=0;
	    	if(au==1)
	    	{
	    		if(qName.equalsIgnoreCase("author")){
	    			tmpAut.setNames(tmpValue);
	    			iswww = true;
	    			isAuthor = true;
	    			//System.out.println(autTmp);
			    }
	    	}
	    	if (qName.equalsIgnoreCase("www")) {
    			autList.add(tmpAut);
    		}
	    	if (found==1){
	    		if(qName.equalsIgnoreCase("author")){
	    			recTmp.addAuthor(tmpValue);
	    		}
	    		if (qName.equalsIgnoreCase("article")) {
	    			recList.add(recTmp);
	    		}
	    		if (qName.equalsIgnoreCase("journal")) {
	    			recTmp.setJournal(tmpValue);
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
	    			d=1;
	    		}
	    	}
	        //System.out.println(i);
	    	if(d==1)
	    		System.out.println(recTmp.toString());
	        //
	    }

	    @Override
	    public void characters(char ch[], int start, int length) throws SAXException {
	    	tmpValue = new String(ch, start, length);
	    }
	    
	    void make_hash(){
	    	String aut=new String();
	    	int ct = -1;
	    	for(Authors Author : autList) {
	    		Author.setMap_val(++ct);
	    		for(int i=0;i<Author.getNames().size();++i){
//	    			System.out.println()
//	    			if(Author.getNames().get(i).equalsIgnoreCase(aut)){
//	    				int size = Author.getNames().size();
//	    				for(int j=0;j<size;++j){
//	        				name.add(Author.getNames().get(j));
//	        				if(Author.getMap_val()==-1){
//	        	    			Author.setMap_val(Author.getN());
//	        	    		}
//	    				}
	    			if(ct%100000 == 0)
	    			{
	    				System.out.println(Author.getNames().get(0));
	    			}
	    				hash.put(Author.getNames().get(i),Author.getMap_val());
	    			}
	    		}
	    		System.out.println(hash.size());
//	    		System.out.println(hash.values());
	    		System.out.println(hash.get(autList.get(0).getNames().get(0)));
	    }
	    	/*if(au.getNames().get(0)!=null){
	    		if(au.getMap_val()==-1){
	    			au.setMap_val(au.getN());
	    		}
	    	}
	    	if(tmpAut!=null)
	    		hash.put(tmpValue,tmpAut.getMap_val());
	    	isAuthor=false;*/
}
