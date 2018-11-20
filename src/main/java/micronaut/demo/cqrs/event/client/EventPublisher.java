package micronaut.demo.cqrs.event.client;

import micronaut.demo.cqrs.event.AbstractEvent;

public interface EventPublisher<T> {

    void publish(AbstractEvent<T> event); 
}
