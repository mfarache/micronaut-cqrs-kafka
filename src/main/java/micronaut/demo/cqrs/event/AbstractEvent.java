package micronaut.demo.cqrs.event;

public abstract class  AbstractEvent<T> {
	
	public abstract String getEventId();
	
	public abstract T getDtoFromEvent();
		
}
