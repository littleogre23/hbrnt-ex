package observer.example;

import java.util.List;

public class CategoryGroup implements Observer{
	
	private List<Subject> categories;
	private double categoryGroupTotal;

	public CategoryGroup(List<Subject> categs) {
		this.categoryGroupTotal = 0;
		this.categories = categs;
		
		for (Subject category : categories) {
			category.registerObserver(this);
		}
	}

	@Override
	public void update(double categoryValue) {
		// System.out.println("value changed: " + categoryValue);
		
		categoryGroupTotal += categoryValue;
		System.out.println("new category group total: " + categoryGroupTotal);
	}

}
