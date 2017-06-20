package aV2.budgeting.example;

public class Expense {

	protected int id;
	protected Category category;
	protected double value;
	
	public Expense(int id, Category category, double value) {
		
		this.id = id;
		this.category = category;
		this.value = value;
		
		// update category.spent
	}
}
