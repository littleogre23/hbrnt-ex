package observer.example;

import java.util.Arrays;
import java.util.List;

public class TestyTest {

	public static void main(String[] args) {
		
		CategoryTest c1 = new CategoryTest();
		CategoryTest c2 = new CategoryTest();
		CategoryTest c3 = new CategoryTest();
		CategoryTest c4 = new CategoryTest();
		CategoryTest c5 = new CategoryTest();
		
		List<SubjectTest> categories = Arrays.asList(c1, c2, c3, c4, c5);
		
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
