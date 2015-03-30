import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;


public class Controller {
	
	private  Vector<String> fruits = new Vector<String>();
	
	
	
	public Controller(){
		
		fruits.add("Tomatoes");
		fruits.add("Apple");
		fruits.add("Mango");
		fruits.add("Grapes");
		fruits.add("Strawberry");
		fruits.add("Blueberries");
		
	}
	 
	public Vector<String> getFruits() {
		return fruits;
	}
	
	 public void setFruits(Vector<String> fruits) {
		
	 }
	

	
	public Iterator resort(Comparator cp){
			Collections.sort(fruits,cp);		 	 
		return  fruits.iterator();
	 }
	


}
	
	
	
	

