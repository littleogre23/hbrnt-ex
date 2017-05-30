package observer.example;

import java.util.ArrayList;
import java.util.List;

public class Category implements Subject {
	
	private double value;
	private List<Observer> observers;

	public Category() {
		this.observers = new ArrayList<>();
		this.value = 0;
	}

	public void setValue(double value) {
		this.value = value;
		notifyObservers();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (Observer o : observers) {	
			o.update(value);
		}
	}

}
