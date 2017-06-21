package aV2.budgeting.example;

import java.util.List;

public class BudgetRepo extends AbstractRepo {

	
	public BudgetRepo(List<AbstractBudget> ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	public void addCategoryToBudget(int id, Category category) {
		
		Budget budget = (Budget) GetById(id);
	}

}
