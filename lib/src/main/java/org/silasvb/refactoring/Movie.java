/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.silasvb.refactoring;

public abstract class Movie {

  public static final int CHILDRENS = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;

  private final String title;

  public static Movie createMovie(String title, int priceCode) {
    if (priceCode == CHILDRENS) {
      return new ChildrensMovie(title);
    }
    if (priceCode == REGULAR) {
      return new RegularMovie(title);
    }

    if (priceCode == NEW_RELEASE) {
      return new NewRelease(title);
    }

    return null;
  }

  protected Movie(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public abstract int getPiceCode();

  public abstract double getCharge(int daysRented);

  public abstract int getFrequentRenterPoints(int duration);
}
