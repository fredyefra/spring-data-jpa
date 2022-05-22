package br.com.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.spring.jpa.model.Cabin;

@Repository
public interface CabinRepository extends JpaRepository<Cabin, Long>, JpaSpecificationExecutor<Cabin> {

		
}
