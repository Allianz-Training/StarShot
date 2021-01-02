package com.allianz.finalproject.starshot.bussiness.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends CrudRepository<InsuranceRegistration, Integer> {
  // List<InsuranceRegistration> findByFirst_name(String first_name);
  //
  // InsuranceRegistration findByEmail(String email);
  //
  // InsuranceRegistration findByAddress(String address);

}
