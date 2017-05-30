package budgeting.example;

import java.util.UUID;

public class CategoryGroup {
	
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

	public CategoryGroup() {
	}

	public CategoryGroup(String name) {
		this.Id = UUID.randomUUID();
		this.name = name;
	}
}
