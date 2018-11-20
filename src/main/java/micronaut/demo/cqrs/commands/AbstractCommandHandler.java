package micronaut.demo.cqrs.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import micronaut.demo.cqrs.event.AbstractEvent;
import micronaut.demo.cqrs.event.client.EventPublisher;
import micronaut.demo.cqrs.model.Command;
import micronaut.demo.cqrs.model.CommandHandler;
import micronaut.demo.cqrs.model.Result;
import micronaut.demo.movie.services.write.Dao;

public abstract class AbstractCommandHandler<T> implements CommandHandler<Command<T>, T> {

	protected static final Logger LOG = LoggerFactory.getLogger(AbstractCommandHandler.class);

	protected Dao<T> dao;

	private EventPublisher<T> publisher;

	public AbstractCommandHandler(Dao<T> dao, EventPublisher<T> publisher) {
		this.dao = dao;
		this.publisher = publisher;
	}

	@Override
	public Result<T> handleCommand(Command<T> command) {
		T dto = getDto(command);
		save(dto);
		publish( buildEvent(dto));
		return buildResult(dto);
	}

	abstract void save(T dto);

	abstract T getDto(Command<T> command);

	abstract AbstractEvent<T> buildEvent(T dto);

	void publish(AbstractEvent<T> event) {
		if (event != null) {
			publisher.publish(event);
		}
	}

	abstract Result<T> buildResult(T dto);

}
