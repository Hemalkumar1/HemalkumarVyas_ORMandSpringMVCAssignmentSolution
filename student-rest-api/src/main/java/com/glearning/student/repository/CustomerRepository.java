package com.glearning.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glearning.student.model.Student;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{


}
