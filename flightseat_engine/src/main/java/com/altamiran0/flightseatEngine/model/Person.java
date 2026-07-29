package com.altamiran0.flightseatEngine.model;

public class Person {
  private String DNI;
  private String name;
  private String lastname;
  private String birthDate;

  public Person( String DNI, String name, String lastname, String birthDate ) {
    setDNI( DNI );
    setName( name );
    setLastname( lastname );
    setBirthDate( birthDate );
  }

  public String getDNI() {
    return DNI;
  }

  public void setDNI(String DNI) { this.DNI = DNI; }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  @Override
  public String toString() {
    return "Person{" +
        "DNI='" + DNI + '\'' +
        ", name='" + name + '\'' +
        ", lastname='" + lastname + '\'' +
        ", birthDate='" + birthDate + '\'' +
        '}';
  }
}
