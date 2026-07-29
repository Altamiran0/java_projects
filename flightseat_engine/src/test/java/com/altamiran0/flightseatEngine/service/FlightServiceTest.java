package com.altamiran0.flightseatEngine.service;

import com.altamiran0.flightseatEngine.model.Flight;
import com.altamiran0.flightseatEngine.model.Person;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class FlightServiceTest {
  /*What test do I need?
  * 1. I need to assign a seat to Jose Martinez
  * 2. I need to see if a specific flight has any available seat.*/

  public Person joseMartinez = new Person(
      "12345678",// DNI
      "Jose",// name
      "Martinez",// lastname
      "1998-08-15"// birthdate
  );

  public Person lauraFernandez = new Person(
      "87654321",// DNI
      "Laura",// name
      "Fernandez",// lastname
      "1978-04-12"// birthdate
  );

  public Flight flight = new Flight(
      "F7725",// id
      "Buenos Aires",// origin
      "Tokyo",// destination
      "2026-04-15T15:41:23+00:00"// takeoffAt
  );

  /**
   * 1st Test: Assign a seat to Jose Martinez.
   */
  @Test
  void assignSeatToJoseMartinez(){
    boolean hasASeat = flight.assignSeat( joseMartinez );
    assertTrue( hasASeat );
  }

  /**
   * 2nd Test: Assign the A23 seat to Jose Martinez.
   */
  @Test
  void assignSpecificSeatToLauraFernandez(){
    boolean hasASeat = flight.assignSeat( lauraFernandez, "A23" );
    assertTrue( hasASeat );
  }

  /**
   * 3rd Test: Given a flight, search an available seat.
   */
  @Test
  void searchAnAvailableSeat(){
    boolean thereIsAnAvailableSeat = flight.findAvailableSeat() != null;
    assertTrue( thereIsAnAvailableSeat );
  }
}
