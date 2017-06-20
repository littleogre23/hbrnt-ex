package aV2.budgeting.example;

public abstract class AbstractBudget {

	protected int id;
	protected String name;
	protected double budgeted;
	protected double spent;
	protected double remainingToSpend; // budgeted - spent
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public double getRemainingToSpend() {
		return remainingToSpend;
	}
	public void setRemainingToSpend(double remainingToSpend) {
		this.remainingToSpend = remainingToSpend;
	}

}
