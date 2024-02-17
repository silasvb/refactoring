package org.silasvb.refactoring;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RentalTest {

  private static Stream<Arguments> provideCharges() {
    return Stream.of(
        Arguments.of(0, 2f, Movie.REGULAR),
        Arguments.of(2, 2f, Movie.REGULAR),
        Arguments.of(3, 3.5, Movie.REGULAR),
        Arguments.of(6, 8f, Movie.REGULAR),
        Arguments.of(0, 0, Movie.NEW_RELEASE),
        Arguments.of(1, 3, Movie.NEW_RELEASE),
        Arguments.of(2, 6, Movie.NEW_RELEASE),
        Arguments.of(0, 1.5, Movie.CHILDRENS),
        Arguments.of(3, 1.5, Movie.CHILDRENS),
        Arguments.of(4, 3, Movie.CHILDRENS));
  }

  @ParameterizedTest
  @MethodSource("provideCharges")
  void getChargeTest(int duration, double expectedAmount, int movieType) {
    Rental rental = new Rental(new Movie("", movieType), duration);
    assertEquals(expectedAmount, rental.getCharge());
  }

  private static Stream<Arguments> provideRentalPoints() {
    return Stream.of(
        Arguments.of(0, Movie.CHILDRENS, 1),
        Arguments.of(0, Movie.NEW_RELEASE, 1),
        Arguments.of(0, Movie.REGULAR, 1),
        Arguments.of(1, Movie.CHILDRENS, 1),
        Arguments.of(1, Movie.NEW_RELEASE, 1),
        Arguments.of(1, Movie.REGULAR, 1),
        Arguments.of(2, Movie.CHILDRENS, 1),
        Arguments.of(2, Movie.NEW_RELEASE, 2));
  }

  @ParameterizedTest
  @MethodSource("provideRentalPoints")
  void getRentalPoints(int duration, int movieType, int expectedRentalPoints) {}
}
