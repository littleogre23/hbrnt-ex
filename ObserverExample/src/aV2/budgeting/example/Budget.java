package aV2.budgeting.example;

import java.util.ArrayList;
import java.util.List;

public class Budget extends AbstractBudget implements ObserveBudgeted, ObserveSpent {

    private double availableToBudget;
    private double remainingToBudget;

    private List<Category> categories;

    public Budget(int id, String name, double available) {

        this.id = id;
        this.name = name;
        this.availableToBudget = available;

        this.categories = new ArrayList<Category>();

        // following not available to users:
        this.budgeted = 0;
        this.remainingToBudget = availableToBudget - budgeted;
        this.spent = 0;
        this.remainingToSpend = budgeted - spent;
    }

    public void addCategory(Category category) {

        // could become: updatebudgeted (category.budgeted)
        this.budgeted += category.budgeted;
        this.remainingToBudget = availableToBudget - budgeted;

        // could become updatespent (category.spent)
        this.spent += category.spent;
        this.remainingToSpend = budgeted - spent;

        categories.add(category);
    }

    // observer'd

    @Override
    public void updateObservedBudgeted(double difference) {
        updateBudgeted(difference);
    }

    @Override
    public void updateObservedSpent(double difference) {
        updateSpent(difference);
    }



    // update fields

    public void updateAvailableToBudget(double value) {

        this.availableToBudget = value;
        System.out.println("Updated availableToBudget for budget " + id + ": " + availableToBudget);

        this.remainingToBudget = availableToBudget - budgeted;
    }

    public void updateBudgeted(double difference) {

        // System.out.println("---" + difference);
        this.budgeted += difference;

        this.remainingToBudget = availableToBudget - budgeted;
        this.remainingToSpend = budgeted - spent;
    }

    public void updateSpent(double difference) {

        // System.out.println("---" + difference);
        this.spent += difference;

        this.remainingToSpend = budgeted - spent;
    }




    // getters + setters

    public double getAvailableToBudget() {
        return availableToBudget;
    }

    public void setAvailableToBudget(double availableToBudget) {
        this.availableToBudget = availableToBudget;
    }

    public double getRemainingToBudget() {
        return remainingToBudget;
    }

    public void setRemainingToBudget(double remainingToBudget) {
        this.remainingToBudget = remainingToBudget;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }


    @Override
    public String toString() {

        String budget = "\nBudget id " + id + "\n" +
                "availableToBudget: " + availableToBudget + "\n" +
                "budgeted: " + budgeted + "\n" +
                "remainingToBudget: " + remainingToBudget + "\n" +
                "spent: " + spent + "\n" +
                "remainingToSpend: " + remainingToSpend + "\n";

        return budget;
    }
}
