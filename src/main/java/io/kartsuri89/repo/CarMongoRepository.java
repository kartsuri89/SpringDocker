package io.kartsuri89.repo;

import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.kartsuri89.model.Car;
@Repository
@Scope()
public interface CarMongoRepository extends CrudRepository<Car,Integer>{

}
