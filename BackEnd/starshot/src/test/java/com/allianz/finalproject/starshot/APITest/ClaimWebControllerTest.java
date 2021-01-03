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
import com.allianz.finalproject.starshot.bussiness.domain.Claim;
import com.allianz.finalproject.starshot.bussiness.domain.ClaimRepository;



@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClaimWebControllerTest {
  @MockBean
  ClaimRepository claimRepository;


  @BeforeEach
  void setup() {
    List<Claim> claims = new ArrayList<>();
    Claim claim = new Claim();
    claim.setPolicy_number(1);
    claim.setFirst_name("TestFirstName");
    claim.setLast_name("TestLastName");
    claim.setPassport_number("ABC123456");
    claim.setNational_id("1111111111111");
    claim.setPhone_country_code("66");
    claim.setPhone_number("0000000000");
    claim.setEmail("test@mail.com");
    claim.setIncident("This is test for inceident");
    claims.add(claim);

    Mockito.when(claimRepository.findAll()).thenReturn(claims);
  }

  @Autowired
  private MockMvc mvc;

  @Test
  void testEventFindAll() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/getclaim").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(content().string(
            "[{\"policy_number\":1,\"first_name\":\"TestFirstName\",\"last_name\":\"TestLastName\",\"passport_number\":\"ABC123456\",\"national_id\":\"1111111111111\",\"phone_country_code\":\"66\",\"phone_number\":\"0000000000\",\"email\":\"test@mail.com\",\"incident\":\"This is test for inceident\"}]"));
  }

  // @Test
  // void testEventPost() throws Exception {
  //
  // mvc.perform(MockMvcRequestBuilders.post("/postclaim").accept(MediaType.APPLICATION_JSON))
  // .andExpect(status().isOk());
  // }


}
