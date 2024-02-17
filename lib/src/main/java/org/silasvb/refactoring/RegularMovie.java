package org.silasvb.refactoring;

class RegularMovie extends Movie {
  RegularMovie(String title) {
    super(title);
  }

  @Override
  public int getFrequentRenterPoints(int duration) {
    return 1;
  }

  @Override
  public double getCharge(int daysRented) {
    double result = 2;

    if (daysRented > 2) {
      result += (daysRented - 2) * 1.5;
    }

    return result;
  }
}
