package org.silasvb.refactoring;

import org.silasvb.refactoring.price.RegularPrice;

class RegularMovie extends Movie {

  private final RegularPrice price;

  RegularMovie(String title) {
    super(title);
    price = new RegularPrice();
  }

  @Override
  public int getFrequentRenterPoints(int duration) {
    return 1;
  }

  @Override
  public double getCharge(int daysRented) {
    return price.getCharge(daysRented);
  }
}
