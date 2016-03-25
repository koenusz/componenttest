package component.test.domain;

import component.test.Entity;
import component.test.components.BarkComponent;
import component.test.components.BehComponent;
import component.test.components.HealtComponent;
import component.test.event.DeadEvent;
import component.test.event.Event;
import component.test.event.EventListener;
import lombok.Data;

@Data
public class Sheep extends Entity implements BarkComponent, BehComponent, HealtComponent, EventListener {

	private int sheepyness;
	
	public Sheep(String name) {
		super(name);
	}

	@Override
	public void bark() {
		findComponent(BarkComponent.class).bark();
	}

	@Override
	public void beh() {
		findComponent(BehComponent.class).beh();
	}

	@Override
	public int takeDamage(int amount) {
		System.out.println("Damageing " + getName() + " for " + amount);
		return findComponent(HealtComponent.class).takeDamage(amount);
	}

	@Override
	public int heal(int amount) {
		System.out.println("Healing " + getName() + " for " + amount);
		return findComponent(HealtComponent.class).heal(amount);
	}

	@Override
	public void notify(Event event) {

		if (event instanceof DeadEvent) {
			System.out.println(getName() + " is dead");
		}

	};

}
