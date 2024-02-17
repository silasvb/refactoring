package org.silasvb.refactoring;

import org.silasvb.refactoring.price.RegularPrice;
import org.silasvb.refactoring.renterpoints.BasicRenterPoints;

class RegularMovie extends Movie {

  RegularMovie(String title) {
    super(title, new RegularPrice(), new BasicRenterPoints());
  }
}
