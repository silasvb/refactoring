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

  public String htmlStatement() {
    String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
    for (Rental r : rentals) {
      result += r.getMovie().getTitle() + ": " + r.getCharge() + "<BR>\n";
    }

    result += "<P> You owe me <EM>" + getTotalCharge() + "</EM><P>\n";
    result +=
        "On this rental you earned <EM>"
            + getTotalFrequentRenterPoints()
            + "</EM> frequent renter points<P>";

    return result;
  }

  private double getTotalCharge() {
    return rentals.stream().mapToDouble(Rental::getCharge).sum();
  }

  private int getTotalFrequentRenterPoints() {
    return rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
  }
}
