import java.util.Comparator;


public class SortByLength implements Comparator<String> {	
	
	
	@Override
	public int compare(String one, String two) {
		
		if(one.length() < two.length())
			return 1;
		else if(two.length() < one.length())
			return -1;
		
		return 0;
	}
}

	
	

