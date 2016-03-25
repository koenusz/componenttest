package component.test;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
	
	private String name;
	
	public Entity(String name) {
		this.name = name;
	}
	
	private List<Component> components = new ArrayList<>();

	public void addComponent(Component comp) {
		components.add(comp);
	}

	@SuppressWarnings("unchecked")
	public <T> T findComponent(Class<T> clazz) {
		for (Component component : components) {
			if (component.geType().equals(clazz)) {
				return (T) component;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
