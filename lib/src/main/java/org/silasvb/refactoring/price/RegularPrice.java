package org.silasvb.refactoring.price;

public class RegularPrice implements Price {
  @Override
  public double getCharge(int duration) {
    double result = 2;

    if (duration > 2) {
      result += (duration - 2) * 1.5;
    }

    return result;
  }
}
