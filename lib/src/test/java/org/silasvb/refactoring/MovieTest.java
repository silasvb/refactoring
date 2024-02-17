package org.silasvb.refactoring;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MovieTest {

  static class ChildrensMovieTest {

    private static Stream<Arguments> provideCharges() {
      return Stream.of(
        Arguments.of(0, 1.5),
        Arguments.of(3, 1.5),
        Arguments.of(4, 3));
    }

    @ParameterizedTest
    @MethodSource("provideCharges")
    void getChargeTest(int duration, double expectedCharge) {
      assertEquals(expectedCharge, new ChildrensMovie("").getCharge(duration));
    }

  }

  static class RegularMovieTest {

    private static Stream<Arguments> provideCharges() {
      return Stream.of(
              Arguments.of(0, 2),
              Arguments.of(1, 2),
              Arguments.of(3, 3.5),
              Arguments.of(6, 8));
    }

    @ParameterizedTest
    @MethodSource("provideCharges")
    void getChargeTest(int duration, double expectedCharge) {
      assertEquals(expectedCharge, new RegularMovie("").getCharge(duration));
    }

  }

  static class NewReleaseTest {

    private static Stream<Arguments> provideCharges() {
      return Stream.of(
              Arguments.of(0, 0),
              Arguments.of(1, 3),
              Arguments.of(2, 6));
    }

    @ParameterizedTest
    @MethodSource("provideCharges")
    void getChargeTest(int duration, double expectedCharge) {
      assertEquals(expectedCharge, new NewRelease("").getCharge(duration));
    }

  }

  private static Stream<Arguments> provideFrequentRenters() {
    return Stream.of(
        Arguments.of(0, Movie.NEW_RELEASE, 1),
        Arguments.of(0, Movie.REGULAR, 1),
        Arguments.of(0, Movie.CHILDRENS, 1),
        Arguments.of(1, Movie.NEW_RELEASE, 1),
        Arguments.of(1, Movie.CHILDRENS, 1),
        Arguments.of(1, Movie.REGULAR, 1),
        Arguments.of(2, Movie.NEW_RELEASE, 2),
        Arguments.of(2, Movie.CHILDRENS, 1),
        Arguments.of(2, Movie.REGULAR, 1));
  }

  @ParameterizedTest
  @MethodSource("provideFrequentRenters")
  void getFrequentRenters(int duration, int movieType, int expectedFrequentRenterPoints) {
    assertEquals(
        expectedFrequentRenterPoints,
        Movie.createMovie("", movieType).getFrequentRenterPoints(duration));
  }
}
