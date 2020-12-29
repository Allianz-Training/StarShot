package com.allianz.finalproject.starshot.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.allianz.finalproject.starshot.bussiness.domain.Claim;
import com.allianz.finalproject.starshot.bussiness.domain.ClaimRepository;

@RestController
public class ClaimWebController {
  @Autowired
  private ClaimRepository claimRepository;

  @GetMapping("/getclaim")
  public List<Claim> getClaim() {
    return (List<Claim>) claimRepository.findAll();
  }

  @PostMapping("/postclaim")
  public Claim postClaim(@RequestBody Claim claim) {
    return claimRepository.save(claim);
  }

  // @GetMapping("/getclaim")
  // public List<Claim> getContactUs(@RequestBody Claim claim) {
  // return (List<Claim>) claimRepository.findAll();
  // }
}
