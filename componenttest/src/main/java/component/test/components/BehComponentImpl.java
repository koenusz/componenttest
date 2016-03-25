package component.test.components;

import component.test.ComponentImpl;

public class BehComponentImpl extends ComponentImpl implements BehComponent{

	public BehComponentImpl(Class<?> componentType) {
		super(componentType);
	}
	
	public void beh()
	{
		System.out.println("Beehhhhh!");
	}
}
