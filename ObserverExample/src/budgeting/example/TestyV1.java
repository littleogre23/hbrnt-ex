package budgeting.example;

public class TestyV1 {

	public static void main(String[] args) {
	
		// let's try a real world example
		
		BudgetV1 budget = new BudgetV1(1, "iunie-2017", 3270);
		
		CategoryV1 chirie = new CategoryV1(1, "chirie", budget, 575);
		CategoryV1 facturi = new CategoryV1(2, "facturi", budget, 420);
		CategoryV1 mancare = new CategoryV1(3, "mancare", budget, 400);
		
		budget.addCategory(chirie);
		budget.addCategory(facturi);
		budget.addCategory(mancare);
		
		System.out.println(budget);
		
		budget.updateAvailableToBudget(3170);
		
		System.out.println(budget);
		
		facturi.updateBudgeted(0);
		chirie.updateBudgeted(0);
		mancare.updateBudgeted(0);

		System.out.println(budget);
		
//		long startTime = System.currentTimeMillis();
//		for (int i = 0; i < 1000000; i++) {
//			facturi.updateBudgeted(1);
//		}
//		long endTime = System.currentTimeMillis();
//		
//		System.out.println("\n\ntotal runtime: " + ((endTime - startTime) / 1000.0));
//		System.out.println(budget);
	}

}
