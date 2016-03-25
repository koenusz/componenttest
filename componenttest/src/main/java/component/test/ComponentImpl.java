package component.test;

import component.test.event.EventListener;

public abstract class ComponentImpl implements Component {
	
	private EventListener listener;
	
	private Class<?> componentType;

	public ComponentImpl(Class<?> componentType) {
		super();
		this.componentType = componentType;
	}
	
	public ComponentImpl(Class<?> componentType, EventListener listener) {
		super();
		this.componentType = componentType;
		this.listener = listener;
	}

	public Class<?> geType() {
		return componentType;
	}
	
	public EventListener getEventListener()
	{
		return listener;
	}
	

}
