package micronaut.demo.cqrs.model;

public interface CommandHandler<C extends Command<R>, R> {
	Result<R> handleCommand (Command<R> command);
}
