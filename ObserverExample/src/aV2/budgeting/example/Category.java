package aV2.budgeting.example;

public class Category extends AbstractBudget implements ObserveSpent, OnChangeBudgeted, OnChangeSpent {

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

        this.budgeted = value;
        System.out.println("Updated budgeted for category " + id + ": " + budgeted);
        this.remainingToSpend = budgeted - spent;

        notifyChangeBudgeted(difference);
    }

    public void updateSpent(double difference) {

        this.spent += difference;
        this.remainingToSpend = budgeted - spent;
        // System.out.println("Updated spent for category " + id + ": " + spent);

        notifyChangeSpent(difference);
    }


    // observer'd

    @Override
    public void notifyChangeBudgeted(double difference) {
        budget.updateObservedBudgeted(difference);
    }

    @Override
    public void updateObservedSpent(double difference) {
        updateSpent(difference);
    }

    @Override
    public void notifyChangeSpent(double difference) {
        budget.updateObservedSpent(difference);
    }
}

