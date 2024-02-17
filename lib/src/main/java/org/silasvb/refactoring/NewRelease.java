package org.silasvb.refactoring;

import org.silasvb.refactoring.price.NewReleasePrice;

class NewRelease extends Movie {

  NewRelease(String title) {
    super(title, new NewReleasePrice());
  }

  @Override
  public int getFrequentRenterPoints(int duration) {
    if (duration < 2) {
      return 1;
    }
    return 2;
  }
}
