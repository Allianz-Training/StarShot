package com.allianz.finalproject.starshot.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.allianz.finalproject.starshot.bussiness.domain.Event;
import com.allianz.finalproject.starshot.bussiness.domain.EventRepository;
import com.allianz.finalproject.starshot.service.IEventService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@ControllerAdvice
@RestController
public class EventWebController {
  @Autowired
  private EventRepository eventRepository;

  @GetMapping("/getevent")
  public List<Event> getEvent() {
    return (List<Event>) eventRepository.findAll();
  }

  @GetMapping("/getevent/{id}")
  public Event getEvent(@PathVariable Integer id) {
    Event get = eventRepository.findById(id).get();
    System.out.println(get);
    return get;
  }

  // @Autowired
  // private UpComingEvent upComingEvent;
  //
  // @GetMapping("/getevent/upcoming")
  // public ResponseEntity<List<Event>> getEventUpcoming(
  // @RequestParam(defaultValue = "0") Integer pageNo,
  // @RequestParam(defaultValue = "10") Integer pageSize,
  // @RequestParam(defaultValue = "event_name") String sortBy) {
  // List<Event> list = upComingEvent.getEventUpcoming(pageNo, pageSize, sortBy);
  //
  // return new ResponseEntity<List<Event>>(list, HttpStatus.OK);
  // }

  @PostMapping("/postevent")
  public Event postEvent(@RequestBody Event event) {
    return eventRepository.save(event);
  }

  @Autowired
  private IEventService eventService;

  @GetMapping("/getevent/all/upcoming")
  public List<Event> getEventByDate() {

    return eventService.findAllOrderByDate();
  }

  @GetMapping("/getevent/music/upcoming")
  public List<Event> getMusicEventByDate() {

    return eventService.findAllMusicOrderByDate();
  }

  @GetMapping("/getevent/sport/upcoming")
  public List<Event> getSportEventByDate() {

    return eventService.findAllSportOrderByDate();
  }

  @GetMapping("/getevent/conference/upcoming")
  public List<Event> getConferenceEventByDate() {

    return eventService.findAllConferenceOrderByDate();
  }
}
