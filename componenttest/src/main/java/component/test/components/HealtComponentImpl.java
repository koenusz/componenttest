package component.test.components;

import component.test.ComponentImpl;
import component.test.event.DeadEvent;
import component.test.event.EventListener;

public class HealtComponentImpl extends ComponentImpl implements HealtComponent{

	
	public HealtComponentImpl(Class<HealtComponent> componentType, EventListener listener) {
		super(componentType, listener);
	}
	
	private int totalHitpoint = 10;
	
	@Override
	public int takeDamage(int amount) {
		totalHitpoint -= amount;
		if(totalHitpoint < 0)
		{
			getEventListener().notify(new DeadEvent());
		}
		return totalHitpoint;
	}

	@Override
	public int heal(int amount) {
		totalHitpoint += amount;
		return totalHitpoint;
	}

}
