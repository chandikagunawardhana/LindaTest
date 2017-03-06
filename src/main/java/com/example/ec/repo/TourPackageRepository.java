package main.java.com.example.ec.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import main.java.com.example.ec.domain.TourPackage;

public interface TourPackageRepository extends CrudRepository<TourPackage, String> {

	TourPackage findByName(@Param("name") String name);
}
