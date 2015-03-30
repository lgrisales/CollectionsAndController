import java.util.Comparator;


public class SortAlphabetical implements Comparator<String>{

	
	
	public SortAlphabetical(){
		
		
	}
	@Override
	public int compare(String o1, String o2) {		
		return o1.compareTo(o2);//test
	}

}
