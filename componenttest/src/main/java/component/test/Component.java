package component.test;

public interface Component {
	
	public default Class<?> geType() {
		return (Class<?>) Object.class;
	}

}
