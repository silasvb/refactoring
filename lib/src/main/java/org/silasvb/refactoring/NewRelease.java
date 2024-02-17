package org.silasvb.refactoring;

class NewRelease extends Movie {
  NewRelease(String title) {
    super(title);
  }

  @Override
  public int getPiceCode() {
    return NEW_RELEASE;
  }

  @Override
  public double getCharge(int daysRented) {
    return daysRented * 3.0;
  }

  @Override
  public int getFrequentRenterPoints(int duration) {
    if (duration < 2) {
      return 1;
    }
    return 2;
  }
}
