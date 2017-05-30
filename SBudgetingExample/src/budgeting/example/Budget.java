package budgeting.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Budget {
	
	private UUID Id;
	private String name;
	private double availableToBudget;
	private double budgeted;
	private double remainingToBudget;
	private double spent;
	private double remaining;
	
	private List<BudgetedCategoryGroup> budgetedCategoryGroups;

	public Budget() {
	}

	public Budget(String name, double available) {
		this.Id = UUID.randomUUID();
		this.name = name;
		this.availableToBudget = available;
		this.budgeted = 0;
		this.remainingToBudget = availableToBudget - budgeted;
		this.spent = 0;
		this.remaining = budgeted - spent;
		
		this.budgetedCategoryGroups = new ArrayList<>();
	}
	
	public void addCategoryGroup(BudgetedCategoryGroup catgroup) {
		this.budgetedCategoryGroups.add(catgroup);
		this.budgeted += catgroup.getBudgeted();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getId() {
		return Id;
	}

	public double getAvailableToBudget() {
		return availableToBudget;
	}

	public void setAvailableToBudget(double availableToBudget) {
		this.availableToBudget = availableToBudget;
	}

	public double getBudgeted() {
		return budgeted;
	}

	public void setBudgeted(double budgeted) {
		this.budgeted = budgeted;
	}

	public double getRemainingToBudget() {
		return remainingToBudget;
	}

	public void setRemainingToBudget(double remainingToBudget) {
		this.remainingToBudget = remainingToBudget;
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

	public void setId(UUID id) {
		Id = id;
	}

	public List<BudgetedCategoryGroup> getBudgetedCategoryGroups() {
		return budgetedCategoryGroups;
	}

	public void setBudgetedCategoryGroups(List<BudgetedCategoryGroup> budgetedCategoryGroups) {
		this.budgetedCategoryGroups = budgetedCategoryGroups;
	}
}
