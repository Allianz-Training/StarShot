package com.allianz.finalproject.starshot.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.allianz.finalproject.starshot.bussiness.domain.Event;
import com.allianz.finalproject.starshot.bussiness.domain.EventReopository;

@RestController
public class EventController {
  @Autowired
  private EventReopository eventReopository;

  @GetMapping("/getevent")
  public List<Event> getEvent() {
    return (List<Event>) eventReopository.findAll();
  }

  @GetMapping("/getevent/{id}")
  public Event getEvent(@PathVariable Integer id) {
    Event get = eventReopository.findById(id).get();
    System.out.println(get);
    return get;
  }

  @PostMapping("/postevent")
  public Event postEvent(@RequestBody Event event) {
    return eventReopository.save(event);
  }
}
