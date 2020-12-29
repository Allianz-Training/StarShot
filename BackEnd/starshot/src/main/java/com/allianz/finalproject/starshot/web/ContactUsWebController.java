package com.allianz.finalproject.starshot.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.allianz.finalproject.starshot.bussiness.domain.ContactUs;
import com.allianz.finalproject.starshot.bussiness.domain.ContactUsRepository;

@RestController
public class ContactUsWebController {
  @Autowired
  private ContactUsRepository contactUsRepository;

  @RequestMapping("/test")
  @ResponseBody
  String home() {
    // DTO
    //
    // JPA
    return "Hello World!";
  }

  @PostMapping("/postcontactus")
  public ContactUs addContactUs(@RequestBody ContactUs contactUs) {
    return contactUsRepository.save(contactUs);

  }



  @GetMapping("/getcontactus/{id}")
  public ContactUs getContactUs(@PathVariable Integer id) {
    ContactUs get = contactUsRepository.findById(id).get();
    System.out.println(get);
    return get;
  }


  @GetMapping("/getcontactus/all")
  public List<ContactUs> getAllContactUs() {
    return (List<ContactUs>) contactUsRepository.findAll();
  }



  // @GetMapping("/getcontactus")
  // public List<ContactUs> getContactUs(@RequestBody ContactUs contactUs) {
  // return (List<ContactUs>) contactUsRepository.findById();
  // }
}
