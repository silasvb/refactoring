package org.silasvb.refactoring;

class Rental {
  private Movie movie;
  private int daysRented;

  public Rental(Movie movie, int daysRented) {
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  public double getCharge() {
    return movie.getCharge(daysRented);
  }

  public int getFrequentRenterPoints() {
    int frequentRenterPoints = 1;

    if (getMovie().getPiceCode() == Movie.NEW_RELEASE && getDaysRented() > 1) {
      frequentRenterPoints++;
    }
    return frequentRenterPoints;
  }
}
