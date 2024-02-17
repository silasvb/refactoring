package org.silasvb.refactoring.renterpoints;

public class NewReleaseRenterPoints implements RenterPoints {

  @Override
  public int getRenterPoints(int duration) {
    if (duration < 2) {
      return 1;
    }
    return 2;
  }
}
