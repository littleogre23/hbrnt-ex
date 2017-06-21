package aV2.budgeting.example;

public class Expense implements OnChangeSpent {

    protected int id;
    protected Category category;
    protected double value;

    public Expense(int id, Category category, double value) {

        this.id = id;
        this.category = category;
        this.value = value;

        // update category.spent
        notifyChangeSpent(value);
    }

    public void updateValue(double newValue) {

        double difference = newValue - value;

        this.value = newValue;

        notifyChangeSpent(difference);
    }

    @Override
    public void notifyChangeSpent(double difference) {
        category.updateObservedSpent(difference);
    }
}
