package component.test.components;

import component.test.ComponentImpl;

public class BarkComponentImpl extends ComponentImpl implements BarkComponent {

	public BarkComponentImpl(Class<?> componentType) {
		super(componentType);
	}

	@Override
	public void bark() {
		System.out.println("Woof!");

	}

}
