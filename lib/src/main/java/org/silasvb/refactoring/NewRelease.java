package org.silasvb.refactoring;

import org.silasvb.refactoring.price.NewReleasePrice;
import org.silasvb.refactoring.renterpoints.NewReleaseRenterPoints;

class NewRelease extends Movie {

  NewRelease(String title) {
    super(title, new NewReleasePrice(), new NewReleaseRenterPoints());
  }
}
