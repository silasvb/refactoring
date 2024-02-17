package org.silasvb.refactoring;

import org.silasvb.refactoring.price.ChildrensMoviePrice;
import org.silasvb.refactoring.renterpoints.RenterPoints;

class ChildrensMovie extends Movie {

  private static class ChildrensMovieRenterPoints implements RenterPoints {

    @Override
    public int getRenterPoints(int duration) {
      return 1;
    }
  }
  private final RenterPoints renterPoints;

  ChildrensMovie(String title) {
    super(title, new ChildrensMoviePrice());
    renterPoints = new ChildrensMovieRenterPoints();
  }

  @Override
  public int getFrequentRenterPoints(int duration) {
    return renterPoints.getRenterPoints(duration);
  }
}
