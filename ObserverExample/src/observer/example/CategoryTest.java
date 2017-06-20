package observer.example;

import java.util.ArrayList;
import java.util.List;

public class CategoryTest implements SubjectTest {
	
	private double value;
	private List<ObserverTest> observers;

	public CategoryTest() {
		this.observers = new ArrayList<>();
		this.value = 0;
	}

	public void setValue(double value) {
		this.value = value;
		notifyObservers();
	}

	@Override
	public void registerObserver(ObserverTest o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(ObserverTest o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (ObserverTest o : observers) {	
			o.update(value);
		}
	}

}
