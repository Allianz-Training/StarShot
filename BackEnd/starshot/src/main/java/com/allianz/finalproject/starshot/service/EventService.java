package com.allianz.finalproject.starshot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.allianz.finalproject.starshot.bussiness.domain.Event;
import com.allianz.finalproject.starshot.bussiness.domain.EventRepository;

@Service
public class EventService implements IEventService {

  @Autowired
  private EventRepository eventReopository;

  //
  // public List<Event> getEventUpcoming(Integer pageNo, Integer pageSize, String sortBy) {
  // Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
  //
  // Page<Event> pagedResult = eventReopository.findAll(paging);
  //
  // if (pagedResult.hasContent()) {
  // return pagedResult.getContent();
  // } else {
  // return new ArrayList<Event>();
  // }
  //
  // }

  @Override
  public List<Event> findAllOrderByDate() {
    return eventReopository.findAllOrderByDate();


  }

}

