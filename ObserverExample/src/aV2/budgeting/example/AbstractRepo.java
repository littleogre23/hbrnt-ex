package aV2.budgeting.example;

import java.util.List;

public class AbstractRepo {

	List<AbstractBudget> context;
	
	public AbstractRepo(List<AbstractBudget> ctx) {
		context = ctx;
	}

	public List<AbstractBudget> GetAll() {
		return context;
	}
	
	public AbstractBudget GetById(int id) {
		
		return context.stream().filter(t -> t.id == id).findFirst().get();
	}
	
	public void Insert(AbstractBudget entity) {
		context.add(entity);
	}
	
	public void Update(AbstractBudget entity) {
		context.remove(entity);
		context.add(entity);
	}
	
}
