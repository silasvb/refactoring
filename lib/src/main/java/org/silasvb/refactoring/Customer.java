package org.silasvb.refactoring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

class Customer {

  private String name;
  private List<Rental> rentals;

  public Customer(String name) {
    this.name = name;
    rentals = new ArrayList<>();
  }

  public void addRental(Rental rental) {
    rentals.add(rental);
  }

  public String getName() {
    return name;
  }

  public String statement() {

    String result = "Rental Record for " + getName() + "\n";

    Enumeration<Rental> r = Collections.enumeration(rentals);
    while (r.hasMoreElements()) {
      Rental each = r.nextElement();
      result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
    }

    result += "Amount owed is " + getTotalCharge() + "\n";
    result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";

    return result;
  }

  private double getTotalCharge() {
    return rentals.stream().mapToDouble(Rental::getCharge).sum();
  }

  private int getTotalFrequentRenterPoints() {
    return  rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
  }

}
