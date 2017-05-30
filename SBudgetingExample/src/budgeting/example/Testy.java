package budgeting.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Testy {

	public static void main(String[] args) {
		
		Budget budget = new Budget("mai2017", 2915);
		Budget budget2 = new Budget("iunie2017", 3295);
		
		CategoryGroup cg1 = new CategoryGroup("obligatorii");
		CategoryGroup cg2 = new CategoryGroup("optionale");
		Category facturi = new Category("facturi");
		Category chirie = new Category("chirie");
		
		BudgetedCategoryGroup bcg1 = new BudgetedCategoryGroup(cg1, budget);
		BudgetedCategory bc1 = new BudgetedCategory(facturi, bcg1, 400);
		BudgetedCategory bc2 = new BudgetedCategory(chirie, bcg1, 575);
		
		BudgetedCategoryGroup bcg2 = new BudgetedCategoryGroup(cg2, budget);
		BudgetedCategory bc3 = new BudgetedCategory(chirie, bcg2, 200);
		
		BudgetedCategoryGroup bcg3 = new BudgetedCategoryGroup(cg1, budget2);
		BudgetedCategory bc4 = new BudgetedCategory(chirie, bcg3, 400);
		
		bcg1.addBudgetedCategory(bc1);
		bcg1.addBudgetedCategory(bc2);
		
		bcg2.addBudgetedCategory(bc3);
		
		bcg3.addBudgetedCategory(bc4);
		
		budget.addCategoryGroup(bcg1);
		budget.addCategoryGroup(bcg2);
		
		budget2.addCategoryGroup(bcg3);

		System.out.println(budget.getName());
		System.out.println(budget.getBudgetedCategoryGroups());
		System.out.println(budget.getAvailableToBudget());
		System.out.println(budget.getBudgeted());
		
		System.out.println(bcg1.getBudgeted());
		System.out.println(bcg1.getBudgetedCategories());
		
		List<Category> usedCategories = budget.getBudgetedCategoryGroups().stream()
				.flatMap(bcg -> bcg.getBudgetedCategories().stream())
				.map(bc -> bc.getCategory())
				.collect(Collectors.toList());
		
		usedCategories.forEach(c -> System.out.println(c.getId()));
		
		List<BudgetedCategory> allBudgetedCategories = budget.getBudgetedCategoryGroups().stream()
				.flatMap(bcg -> bcg.getBudgetedCategories().stream())
				// .filter(bc -> bc.getCategory().getId().equals(chirie.getId()))
				.collect(Collectors.toList());
		
		// allBudgetedCategories.forEach(bc -> System.out.println(bc.getBudgetedCategoryGroup().getCategoryGroup().getName()));
		
		List<Budget> budgets = Arrays.asList(budget, budget2);
		
		allBudgetedCategories = budgets.stream()
				.flatMap(b -> b.getBudgetedCategoryGroups().stream())
				.flatMap(bcg -> bcg.getBudgetedCategories().stream())
				.filter(bc -> bc.getCategory().getId().equals(chirie.getId()))
				.collect(Collectors.toList());
		
		allBudgetedCategories.forEach(bc -> System.out.println(bc.getBudgetedCategoryGroup().getBudget().getName()));
	}

}
