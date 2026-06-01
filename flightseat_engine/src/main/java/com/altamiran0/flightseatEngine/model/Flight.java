package com.altamiran0.flightseatEngine.model;
import com.altamiran0.flightseatEngine.exception.*;
import java.util.HashMap;

public class Flight {
  private String id;
  private String origin;
  private String destination;
  private String boardingTime;

  private HashMap< String, Person > seats = new HashMap<>();

  public Flight( String id, String origin, String destination, String boardingTime ) {
    setId( id );
    setOrigin( origin );
    setDestination( destination );
    setBoardingTime( boardingTime );
    setSeats();
  }

  public String getId() { return id; }

  public String getOrigin() { return origin; }

  public String getDestination() { return destination; }

  public String getBoardingTime() { return boardingTime; }

  public void setId(String id ) { this.id = id; }

  public void setOrigin( String origin ) { this.origin = origin; }

  public void setDestination( String destination ) { this.destination = destination; }

  public void setBoardingTime( String boardingTime ) { this.boardingTime = boardingTime; }

  private void setSeats() {
    final int QUANTITY_SEAT_IN_A_COLUMN = 37;
    for( char letter = 'A'; letter < 'E'; letter++ ) {
      for( int i = 0; i < QUANTITY_SEAT_IN_A_COLUMN; i++ ) {
        String seatID = letter + Integer.toString( i );
        seats.put( seatID, null );
      }
    }
  }

  public String findAvailableSeat() {
    for( var entry: seats.entrySet() ) {
      if( entry.getValue() == null )
        return entry.getKey();
    }
    throw new FlightFullException( "There are no available seats on this flight." );
  }

  public Boolean isAvailableThisSeat( String seatID ) {
    return seats.get( seatID ) == null;
  }

  public Boolean assignSeat( Person customer ) {
    var availableSeatID = findAvailableSeat();
    return
      seats.replace( availableSeatID, null, customer );
  }

  public Boolean assignSeat( Person customer, String seatID ){
    if( seats.containsKey( seatID ) && isAvailableThisSeat( seatID ) ){
      return seats.replace( seatID, null, customer );
    }
    throw new SeatAlreadyBookedException( "Seat " + seatID + " is already reserved." );
  }
}
