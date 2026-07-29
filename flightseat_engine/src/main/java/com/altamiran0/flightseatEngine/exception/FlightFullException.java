package com.altamiran0.flightseatEngine.exception;

public class FlightFullException extends RuntimeException{
  public FlightFullException(String message) {
    super(message); // Passes the message up to RuntimeException
  }
}
