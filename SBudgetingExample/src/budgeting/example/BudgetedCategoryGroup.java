package budgeting.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BudgetedCategoryGroup {
	
	private UUID Id;
	private CategoryGroup categoryGroup;
	private Budget budget;
	private double budgeted;
	private double spent;
	private double remaining;
	
	private List<BudgetedCategory> budgetedCategories;

	public BudgetedCategoryGroup() {
	}
	
	public BudgetedCategoryGroup(CategoryGroup categoryGroup, Budget budget) {
		this.Id = UUID.randomUUID();
		this.categoryGroup = categoryGroup;
		this.budget = budget;
		this.budgeted = 0;
		this.spent = 0;
		this.remaining = budgeted - spent;
		
		budgetedCategories = new ArrayList<>();
	}
	
	public void addBudgetedCategory(BudgetedCategory budcat) {
		this.budgetedCategories.add(budcat);
		this.budgeted += budcat.getBudgeted();
	}

	public UUID getId() {
		return Id;
	}

	public CategoryGroup getCategoryGroup() {
		return categoryGroup;
	}

	public void setCategoryGroup(CategoryGroup categoryGroup) {
		this.categoryGroup = categoryGroup;
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

	public List<BudgetedCategory> getBudgetedCategories() {
		return budgetedCategories;
	}

	public void setBudgetedCategories(List<BudgetedCategory> budgetedCategories) {
		this.budgetedCategories = budgetedCategories;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

}
