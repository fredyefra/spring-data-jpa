package br.com.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.jpa.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
