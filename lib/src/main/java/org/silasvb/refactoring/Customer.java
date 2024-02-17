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
    double totalAmount = 0;
    int frequentRenterPoints = 0;

    String result = "Rental Record for " + getName() + "\n";

    Enumeration _rentals = Collections.enumeration(rentals);
    while (_rentals.hasMoreElements()) {
      Rental each = (Rental) _rentals.nextElement();

      double thisAmount = each.getCharge();
      frequentRenterPoints++;

      if (each.getMovie().getPiceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1) {
        frequentRenterPoints++;
      }

      result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
      totalAmount += thisAmount;
    }

    result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

    return result;
  }
}
