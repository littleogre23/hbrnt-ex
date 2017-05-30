package observer.example;

import java.util.Arrays;
import java.util.List;

public class Testy {

	public static void main(String[] args) {
		
		Category c1 = new Category();
		Category c2 = new Category();
		Category c3 = new Category();
		Category c4 = new Category();
		Category c5 = new Category();
		
		List<Subject> categories = Arrays.asList(c1, c2, c3, c4, c5);
		
		new CategoryGroup(categories);
		
		System.out.println("Testy...");

		c1.setValue(15);
		c2.setValue(575);
		c3.setValue(12.5);
		c4.setValue(65);
		c5.setValue(1.75);
		c1.setValue(-45);
	}

}
