package org.silasvb.refactoring;

import org.silasvb.refactoring.price.NewReleasePrice;
import org.silasvb.refactoring.price.Price;

class NewRelease extends Movie {

  private final Price price;

  NewRelease(String title) {
    super(title);
    price = new NewReleasePrice();
  }

  @Override
  public double getCharge(int daysRented) {
    return price.getCharge(daysRented);
  }

  @Override
  public int getFrequentRenterPoints(int duration) {
    if (duration < 2) {
      return 1;
    }
    return 2;
  }
}
