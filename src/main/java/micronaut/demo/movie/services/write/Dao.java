package micronaut.demo.movie.services.write;

public interface Dao<T> {

	void save(T object);

}
