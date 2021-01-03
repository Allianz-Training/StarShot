package com.allianz.finalproject.starshot.bussiness.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends CrudRepository<InsuranceRegistration, Integer> {
  // List<InsuranceRegistration> findByFirst_name(String first_name);
  //
  // InsuranceRegistration findByEmail(String email);
  //
  // InsuranceRegistration findByAddress(String address);
  @Query(value = "SELECT * FROM user_account ORDER BY policy_number DESC LIMIT 1;",
      nativeQuery = true)

  InsuranceRegistration findPolicyNumber();
}
