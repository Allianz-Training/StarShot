package com.allianz.finalproject.starshot.bussiness.domain;



import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface EventRepository extends CrudRepository<Event, Integer> {

  @Query(value = "SELECT * FROM event_info ORDER BY event_date DESC LIMIT 3", nativeQuery = true)
  // @Query(value = "SELECT * FROM event_info ORDER BY event_type", nativeQuery = true)
  List<Event> findAllOrderByDate();

  @Query(
      value = "SELECT * FROM event_info WHERE event_type=\"music\" ORDER BY event_date DESC LIMIT 3",
      nativeQuery = true)
  // @Query(value = "SELECT * FROM event_info ORDER BY event_type", nativeQuery = true)
  List<Event> findAllMusicOrderByDate();

  @Query(
      value = "SELECT * FROM event_info WHERE event_type=\"sport\" ORDER BY event_date DESC LIMIT 3",
      nativeQuery = true)
  // @Query(value = "SELECT * FROM event_info ORDER BY event_type", nativeQuery = true)
  List<Event> findAllSportOrderByDate();

  @Query(
      value = "SELECT * FROM event_info WHERE event_type=\"conference\" ORDER BY event_date DESC LIMIT 3",
      nativeQuery = true)
  // @Query(value = "SELECT * FROM event_info ORDER BY event_type", nativeQuery = true)
  List<Event> findAllConferenceOrderByDate();

}

