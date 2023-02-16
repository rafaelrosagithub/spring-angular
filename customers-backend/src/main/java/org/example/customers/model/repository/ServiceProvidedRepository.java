package org.example.customers.model.repository;

import org.example.customers.model.entity.ServiceProvided;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceProvidedRepository extends JpaRepository<ServiceProvided, Integer> {

    @Query("select s from ServiceProvided s join s.client c "
            + "where upper(c.name) like upper(:name) "
            + "and MONTH(s.date) = :month")
    List<ServiceProvided> findByNameClientAndMes(@Param("name") String name, @Param("month") Integer month);
}
