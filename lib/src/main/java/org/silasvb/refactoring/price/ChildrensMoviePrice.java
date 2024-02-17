package org.silasvb.refactoring.price;

public class ChildrensMoviePrice implements Price {

  @Override
  public double getCharge(int duration) {
    double result = 1.5;
    if (duration > 3) {
      result += (duration - 3) * 1.5;
    }
    return result;
  }
}
