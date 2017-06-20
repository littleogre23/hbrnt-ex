package budgeting.example;

import java.util.ArrayList;
import java.util.List;

public class BudgetV1 extends AbstractBudgetV1 implements ObserveBudgetedV1, ObserveSpentV1 {

	private double availableToBudget;
	private double remainingToBudget;
	
	private List<CategoryV1> categories;
	
	public BudgetV1(int id, String name, double available) {
		
		this.id = id;
		this.name = name;
		this.availableToBudget = available;
		
		this.categories = new ArrayList<CategoryV1>();
		
		// following not available to users:
		this.budgeted = 0;
		this.remainingToBudget = availableToBudget - budgeted;
		this.spent = 0;
		this.remainingToSpend = budgeted - spent;
	}
	
	public void addCategory(CategoryV1 category) {
		
		// here we do sum validation!
		// updateBudgeted(category.budgeted);
		// updateSpent(category.spent);
		this.budgeted += category.budgeted;
		this.remainingToBudget = availableToBudget - budgeted;
		this.spent += category.spent;
		this.remainingToSpend = budgeted - spent;
		
		categories.add(category);
	}
	
	
	// observer'd
	@Override
	public void updateObservedBudgeted(double value) {
		updateBudgeted(value);
	}

	@Override
	public void updateObservedSpent(double value) {
		updateSpent(value);
	}
	
	
	// update fields 
	
	public void updateAvailableToBudget(double value) {
		
		this.availableToBudget += (value - availableToBudget);
		System.out.println("Updated availableToBudget for budget " + id + ": " + availableToBudget);
		
		this.remainingToBudget = availableToBudget - budgeted;
	}
	
	public void updateBudgeted(double value) {
		
		this.budgeted += value;
		System.out.println("Updated budgeted for budget " + id + ": " + budgeted);
		
		this.remainingToBudget = availableToBudget - budgeted;
		this.remainingToSpend = budgeted - spent;
	}
	
	public void updateSpent(double value) {
		
		this.spent += (value - spent);
		// System.out.println("Updated spent for budget " + id + ": " + spent);
		
		this.remainingToSpend = budgeted - spent;
	}
	
	
	
	// getters + setters
	
	public double getAvailableToBudget() {
		return availableToBudget;
	}
	public void setAvailableToBudget(double availableToBudget) {
		this.availableToBudget = availableToBudget;
	}
	public double getRemainingToBudget() {
		return remainingToBudget;
	}
	public void setRemainingToBudget(double remainingToBudget) {
		this.remainingToBudget = remainingToBudget;
	}
	public List<CategoryV1> getCategories() {
		return categories;
	}
	public void setCategories(List<CategoryV1> categories) {
		this.categories = categories;
	}


	// toString
	@Override
	public String toString() {
		
		String budget = "\n\nBudget id " + id + "\n" +
				"availableToBudget: " + availableToBudget + "\n" +
				"budgeted: " + budgeted + "\n" +
				"remainingToBudget: " + remainingToBudget + "\n" +
				"spent: " + spent + "\n" +
				"remainingToSpend: " + remainingToSpend + "\n";
		
		return budget;
	}
	
	
	public void updateBudgetSumCategories() {
		
		this.budgeted = 0;
		this.spent = 0;
		this.remainingToSpend = 0;
		
		for (CategoryV1 cat : categories) {
			budgeted += cat.budgeted;
			spent += cat.spent;
			remainingToSpend += cat.remainingToSpend;
		}
	}
}
