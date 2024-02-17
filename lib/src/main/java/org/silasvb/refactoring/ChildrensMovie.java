package org.silasvb.refactoring;

import org.silasvb.refactoring.price.ChildrensMoviePrice;

class ChildrensMovie extends Movie {

  ChildrensMovie(String title) {
    super(title, new ChildrensMoviePrice());
  }

  @Override
  public int getFrequentRenterPoints(int duration) {
    return 1;
  }
}
