package component.test;

import com.orientechnologies.orient.object.db.OObjectDatabaseTx;

import component.test.components.BarkComponent;
import component.test.components.BarkComponentImpl;
import component.test.components.BehComponent;
import component.test.components.BehComponentImpl;
import component.test.components.HealtComponent;
import component.test.components.HealtComponentImpl;
import component.test.domain.Sheep;
import component.test.domain.Simple;

public class Application {

	public static void main(String[] args) {

		BarkComponent barker = new BarkComponentImpl(BarkComponent.class);
		BehComponent beher = new BehComponentImpl(BehComponent.class);

		Sheep sheep = new Sheep("Sandy Sheep");
		sheep.addComponent(barker);
		sheep.addComponent(beher);
		sheep.addComponent(new HealtComponentImpl(HealtComponent.class, sheep));
		sheep.bark();
		sheep.beh();
		sheep.takeDamage(5);
		sheep.heal(10);
		sheep.takeDamage(16);

		sheep.setSheepyness(2);

		String remote = "remote:192.168.99.100:32769/petshop";
		String memory = "memory:petshop";

		OObjectDatabaseTx db = new OObjectDatabaseTx(remote).open("admin", "admin");

		db.getEntityManager().registerEntityClass(Simple.class);
		Simple simple = db.newInstance(Simple.class);
		Simple simple2 = db.newInstance(Simple.class);

		simple2.setSimpleString("easy");
		simple.setSimpleString("erg makkelijk");
		db.save(simple);
		db.save(simple2);


		// db.getEntityManager().registerEntityClass(Sheep.class);
		// try {
		// Sheep sheep2 = db.newInstance(Sheep.class);
		// sheep2.setSheepyness(25);
		// sheep2.bark();
		//
		// } finally {
		// db.close();
		// }
		//
		//

		for (Simple animal : db.browseClass(Simple.class)) {
			System.out.println(animal.getSimpleString());
		}

		db.close();
	}

	public void initDb() {

	}
}
