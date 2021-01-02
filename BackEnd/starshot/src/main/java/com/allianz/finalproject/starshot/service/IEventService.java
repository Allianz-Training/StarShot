package com.allianz.finalproject.starshot.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.allianz.finalproject.starshot.bussiness.domain.Event;

@Service
public interface IEventService {

  List<Event> findAllOrderByDate();

  List<Event> findAllMusicOrderByDate();

  List<Event> findAllSportOrderByDate();

  List<Event> findAllConferenceOrderByDate();
}
