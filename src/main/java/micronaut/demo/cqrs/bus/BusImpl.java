package micronaut.demo.cqrs.bus;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import micronaut.demo.cqrs.commands.CreateMovieCommand;
import micronaut.demo.cqrs.model.Command;
import micronaut.demo.cqrs.model.CommandHandler;
import micronaut.demo.cqrs.model.Result;
import micronaut.demo.movie.model.Movie;

public class BusImpl implements Bus {
	
	protected static final Logger LOG = LoggerFactory.getLogger(BusImpl.class);
	
	private Map<String, CommandHandler<?, ?>> handlers = new HashMap<>();
	
	@Inject 
	public BusImpl(CommandHandler<Command<Movie>, Movie> handler) {
		handlers.put(CreateMovieCommand.class.getSimpleName(), handler );
	}

	@SuppressWarnings("unchecked")
	public <R> Result<R> handleCommand(Command<R> command) {
		LOG.debug("handle command: " + command.getCommandName());
		CommandHandler<Command<R>, R> handler = (CommandHandler<Command<R>, R>) handlers.get(command.getCommandName());
		if (handler!=null) {
			return (Result<R>) handler.handleCommand(command);
		} else {
			return null;
		}
		
	}
	
	public <R> void registerHandlerCommand(Command<R> command, CommandHandler<Command<R>, R> handler)  {
		handlers.putIfAbsent(command.getCommandName(), handler);
	}
}
