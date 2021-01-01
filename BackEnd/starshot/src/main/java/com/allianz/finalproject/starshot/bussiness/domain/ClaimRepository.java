package com.allianz.finalproject.starshot.bussiness.domain;

import org.springframework.data.repository.CrudRepository;

public interface ClaimRepository extends CrudRepository<Claim, Integer> {
  // Claim findByPolicy_number(Integer policy_number);
}
