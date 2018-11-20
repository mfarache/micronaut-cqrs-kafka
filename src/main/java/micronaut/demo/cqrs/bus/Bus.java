package micronaut.demo.cqrs.bus;

import micronaut.demo.cqrs.model.Command;
import micronaut.demo.cqrs.model.CommandHandler;
import micronaut.demo.cqrs.model.Result;

public interface Bus {

	public <R> Result<R> handleCommand(Command<R> command);
	
	public <R> void registerHandlerCommand(Command<R> command, CommandHandler<Command<R>, R> handler) ;

}
