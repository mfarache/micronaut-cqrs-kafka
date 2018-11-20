package micronaut.demo.cqrs.model;

public interface Command<T> {
	
	public default String getCommandName() {
		return this.getClass().getSimpleName();
	}

}
