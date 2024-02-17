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
    int frequentRenterPoints = 0;

    String result = "Rental Record for " + getName() + "\n";

    Enumeration _rentals = Collections.enumeration(rentals);
    while (_rentals.hasMoreElements()) {
      Rental each = (Rental) _rentals.nextElement();

      frequentRenterPoints += each.getFrequentRenterPoints();

      result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
    }

    result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

    return result;
  }

  private double getTotalCharge() {
    return rentals.stream().mapToDouble(Rental::getCharge).sum();
  }

}
