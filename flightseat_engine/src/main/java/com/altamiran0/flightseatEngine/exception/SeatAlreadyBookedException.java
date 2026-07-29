package com.altamiran0.flightseatEngine.exception;

public class SeatAlreadyBookedException extends RuntimeException{
  public SeatAlreadyBookedException(String message) {
    super(message); // Passes the message up to RuntimeException
  }
}
