package budgeting.example;

public class CategoryV1 extends AbstractBudgetV1 implements OnChangeBudgetedV1, OnChangeSpentV1 {
	
	protected BudgetV1 budget;
	
	public CategoryV1(int id, String name, BudgetV1 budget, double budgeted) {
		
		this.id = id;
		this.name = name;
		this.budget = budget;
		this.budgeted = budgeted;
		
		// not available for manual update
		this.spent = 0;
		this.remainingToSpend = budgeted - spent;
	}
	
	public void updateBudgeted(double value) {
		
		double difference = value - budgeted;
		
		this.budgeted += difference;
		this.remainingToSpend = budgeted - spent;
		
		notifyOnChangeBudgeted(difference);
	}
	
	public void updateSpent(double value) {
		
		this.spent += value;
		System.out.println("Updated spent for category " + id + ": " + spent);
		
		this.remainingToSpend = budgeted - spent;
		
		notifyOnChangeSpent(value);
	}

	
	// observer'd

	@Override
	public void notifyOnChangeSpent(double value) {
		budget.updateObservedSpent(value);
		
	}

	@Override
	public void notifyOnChangeBudgeted(double value) {
		budget.updateObservedBudgeted(value);
		
	}

	
	// getters + setters
	
	public BudgetV1 getBudget() {
		return budget;
	}

	public void setBudget(BudgetV1 budget) {
		this.budget = budget;
	}
}
