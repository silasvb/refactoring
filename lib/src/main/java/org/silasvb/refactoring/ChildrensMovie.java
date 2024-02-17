package org.silasvb.refactoring;

import org.silasvb.refactoring.price.Price;

class ChildrensMovie extends Movie {

  public static class ChildrensMoviePrice implements Price {

    @Override
    public double getCharge(int duration) {
      double result = 1.5;
      if (duration > 3) {
        result += (duration - 3) * 1.5;
      }
      return result;
    }
  }

  private final Price price;

  ChildrensMovie(String title) {
    super(title);
    price = new ChildrensMoviePrice();
  }

  @Override
  public double getCharge(int daysRented) {
    return price.getCharge(daysRented);
  }

  @Override
  public int getFrequentRenterPoints(int duration) {
    return 1;
  }
}
