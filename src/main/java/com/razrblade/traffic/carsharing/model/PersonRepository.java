package com.razrblade.traffic.carsharing.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<HomoMobilis, Integer> {

	public Optional<HomoMobilis> findByEmail(String email);

}
