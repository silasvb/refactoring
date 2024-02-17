package org.silasvb.refactoring;

import org.silasvb.refactoring.price.RegularPrice;

class RegularMovie extends Movie {

  RegularMovie(String title) {
    super(title, new RegularPrice());
  }

  @Override
  public int getFrequentRenterPoints(int duration) {
    return 1;
  }
}
