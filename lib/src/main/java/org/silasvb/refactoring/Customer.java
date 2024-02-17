package org.silasvb.refactoring;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Customer {

  private final String name;
  private final List<Rental> rentals;

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

    result +=
        rentals.stream()
            .map(each -> "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n")
            .collect(Collectors.joining());

    result += "Amount owed is " + getTotalCharge() + "\n";
    result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";

    return result;
  }

  public String htmlStatement() {
    String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";

    result +=
        rentals.stream()
            .map(r -> r.getMovie().getTitle() + ": " + r.getCharge() + "<BR>\n")
            .collect(Collectors.joining());

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
