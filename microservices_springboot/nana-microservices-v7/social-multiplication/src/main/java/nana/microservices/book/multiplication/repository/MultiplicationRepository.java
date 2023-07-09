package nana.microservices.book.multiplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nana.microservices.book.multiplication.model.Multiplication;

/**
 * This interface allows us to save and retrieve Multiplications
 */
@Repository
public interface MultiplicationRepository extends CrudRepository<Multiplication, Long> {
}