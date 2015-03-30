import java.util.Comparator;


public class SortByIndexOfi implements Comparator<String> {

	@Override
	public int compare(String one, String two) {
		if(one.indexOf("i") < two.indexOf("i"))
			return -1;
		else if(two.indexOf("i") < one.indexOf("i"))
			return 1;
		else
		
			return 0;
	}
}
		
	


