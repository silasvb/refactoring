package org.silasvb.refactoring;

import org.silasvb.refactoring.price.ChildrensMoviePrice;
import org.silasvb.refactoring.renterpoints.BasicRenterPoints;

class ChildrensMovie extends Movie {

  ChildrensMovie(String title) {
    super(title, new ChildrensMoviePrice(), new BasicRenterPoints());
  }
}
