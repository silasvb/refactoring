package org.silasvb.refactoring.price;

public class NewReleasePrice implements Price {

  @Override
  public double getCharge(int duration) {
    return duration * 3.0;
  }
}
