package aV2.budgeting.example;

public class Category extends AbstractBudget implements OnChangeBudgeted {

	protected Budget budget;
	
	public Category(int id, String name, Budget budget, double budgeted) {
		
		this.id = id;
		this.name = name;
		this.budget = budget;
		this.budgeted = budgeted;
		
		// not available for manual update:
		this.spent = 0;
		this.remainingToSpend = budgeted - spent;
	}
	
	public void updateBudgeted(double value) {
		
		double difference = value - budgeted;
		
		this.budgeted += difference;
		this.remainingToSpend = budgeted - spent;
		
		notifyChangeBudgeted(difference);
	}
	
	
	// observer'd
	
	@Override
	public void notifyChangeBudgeted(double difference) {
		// TODO Auto-generated method stub
		
	}
}
