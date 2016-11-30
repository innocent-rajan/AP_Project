import java.util.ArrayList;

public class Authors {
	private int map_val=-1;
	private int pub;
	private static int n;
	private ArrayList<String> names;
	
	Authors(){
		n++;
		names= new ArrayList<String>();
	}
	
	public int getMap_val() {
		return map_val;
	}

	public void setMap_val(int map_val) {
		this.map_val = map_val;
	}

	public int getPub() {
		return pub;
	}

	public void setPub(int pub) {
		this.pub = pub;
	}

	public static int getN() {
		return n;
	}

	public static void setN(int n) {
		Authors.n = n;
	}

	public ArrayList<String> getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names.add(names);
	}	
	@Override
	public String toString(){
		return "Pub = "+this.pub+" Names = "+this.names;
	}
}
