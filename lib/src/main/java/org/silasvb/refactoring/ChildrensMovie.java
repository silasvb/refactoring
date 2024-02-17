package org.silasvb.refactoring;

class ChildrensMovie extends Movie {
  ChildrensMovie(String title) {
    super(title);
  }

  @Override
  public int getPiceCode() {
    return CHILDRENS;
  }

  @Override
  public double getCharge(int daysRented) {
    double result = 1.5;
    if (daysRented > 3) {
      result += (daysRented - 3) * 1.5;
    }
    return result;
  }

  @Override
  public int getFrequentRenterPoints(int duration) {
    return 1;
  }
}
