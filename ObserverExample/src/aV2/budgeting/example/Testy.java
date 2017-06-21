package aV2.budgeting.example;

public class Testy {

	public static void main(String[] args) {
		
		Budget budget = new Budget(1, "Iunie-2017", 3270);

        System.out.println(budget);

        Category chirie = new Category(1, "chirie", budget, 575);
        Category facturi = new Category(2, "facturi", budget, 420);
        Category mancare = new Category(3, "mancare", budget, 400);

        budget.addCategory(chirie);
        budget.addCategory(facturi);
        budget.addCategory(mancare);

        System.out.println(budget);

        Expense mammamia = new Expense(1, mancare, 54);

        System.out.println(budget);

        Expense chinez = new Expense(2, mancare, 13.5);
        Expense digi = new Expense(3, facturi, 64);

        System.out.println(budget);

        mammamia.updateValue(41);

        System.out.println(budget);

        int digiValue = 64;
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 1000; i++) {
            digi.updateValue(digiValue + i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("\n\nruntime: " + ((endTime - startTime) / 1000.0));

        System.out.println(budget);

	}

}
