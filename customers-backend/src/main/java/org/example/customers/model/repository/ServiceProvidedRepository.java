package org.example.customers.model.repository;

import org.example.customers.model.entity.ServiceProvided;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceProvidedRepository extends JpaRepository<ServiceProvided, Integer> {
}
