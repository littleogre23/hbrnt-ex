package budgeting.example;

import java.util.UUID;

public class BudgetedCategory {
	
	private UUID Id;
	private Category category;
	private BudgetedCategoryGroup budgetedCategoryGroup;
	private double budgeted;
	private double spent;
	private double remaining;

	public BudgetedCategory() {
	}
	
	public BudgetedCategory(Category category, BudgetedCategoryGroup categoryGroup, double budgeted) {
		this.category = category;
		this.budgetedCategoryGroup = categoryGroup;
		this.budgeted = budgeted;
		this.spent = 0;
		this.remaining = budgeted - spent;
	}

	public UUID getId() {
		return Id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getBudgeted() {
		return budgeted;
	}

	public void setBudgeted(double budgeted) {
		this.budgeted = budgeted;
	}

	public double getSpent() {
		return spent;
	}

	public void setSpent(double spent) {
		this.spent = spent;
	}

	public double getRemaining() {
		return remaining;
	}

	public void setRemaining(double remaining) {
		this.remaining = remaining;
	}

	public BudgetedCategoryGroup getBudgetedCategoryGroup() {
		return budgetedCategoryGroup;
	}

	public void setBudgetedCategoryGroup(BudgetedCategoryGroup categoryGroup) {
		this.budgetedCategoryGroup = categoryGroup;
	}

}
