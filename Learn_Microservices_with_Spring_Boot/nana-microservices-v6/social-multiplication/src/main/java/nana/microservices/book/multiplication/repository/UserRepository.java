package nana.microservices.book.multiplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nana.microservices.book.multiplication.model.User;

import java.util.Optional;

/**
 * This interface allows us to save and retrieve Users
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByAlias(final String alias);

}