package com.allianz.finalproject.starshot.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.allianz.finalproject.starshot.bussiness.domain.InsuranceRegistration;
import com.allianz.finalproject.starshot.bussiness.domain.InsuranceRepository;
import com.allianz.finalproject.starshot.service.EmailSender;


@RestController
// @RequestMapping("")
public class InsuranceWebController {
  @Autowired
  private InsuranceRepository insuranceRepository;

  private EmailSender emailSender = new EmailSender();

  @PostMapping("/postregistration")
  public InsuranceRegistration addInsuranceRegistration(
      @RequestBody InsuranceRegistration insuranceRegistration) {
    try {
      emailSender.sendMail(insuranceRegistration.getEmail(), insuranceRegistration.getTitle_name(),
          insuranceRegistration.getFirst_name(), insuranceRegistration.getLast_name());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return insuranceRepository.save(insuranceRegistration);
  }

  @GetMapping("/getinsurance")
  public List<InsuranceRegistration> getinsurance() {
    return (List<InsuranceRegistration>) insuranceRepository.findAll();
  }



}

