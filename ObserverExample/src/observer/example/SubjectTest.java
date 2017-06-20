package observer.example;

public interface SubjectTest {
	
	public void registerObserver(ObserverTest o);
	public void removeObserver(ObserverTest o);
	public void notifyObservers();
	
}
