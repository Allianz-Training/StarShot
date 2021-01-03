package com.allianz.finalproject.starshot.APITest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.allianz.finalproject.starshot.bussiness.domain.ContactUs;
import com.allianz.finalproject.starshot.bussiness.domain.ContactUsRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ContactUsWebControllerTest {
  @MockBean
  ContactUsRepository contactUsRepository;

  @BeforeEach
  void setup() {
    List<ContactUs> contactUss = new ArrayList<>();
    ContactUs contactUs = new ContactUs();
    contactUs.setIdcontact_us(1);
    contactUs.setName("TestName");
    contactUs.setEmail("test@mail.com");
    contactUs.setPhone_country_code("66");
    contactUs.setPhone_number("0000000000");
    contactUs.setMessage("This is test for contact us");
    contactUss.add(contactUs);

    Mockito.when(contactUsRepository.findAll()).thenReturn(contactUss);

    // Mockito.when(contactUsRepository.findById(1)).thenReturn(Optional.of(contactUss));

  }

  @Autowired
  private MockMvc mvc;

  @Test
  void testContactUsFindAll() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/getcontactus/all").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(content().string(
            "[{\"idcontact_us\":1,\"name\":\"TestName\",\"email\":\"test@mail.com\",\"phone_country_code\":\"66\",\"phone_number\":\"0000000000\",\"message\":\"This is test for contact us\"}]"));
  }


}
