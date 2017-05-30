package budgeting.example;

import java.util.UUID;

public class Category {
	
	private UUID Id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getId() {
		return Id;
	}

	public Category() {	
	}
	
	public Category(String name) {
		this.Id = UUID.randomUUID();
		this.name = name;
	}

}
