package org.silasvb.refactoring;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MovieTest {

  private static Stream<Arguments> provideCharges() {
    return Stream.of(
        Arguments.of(0, Movie.REGULAR, 2),
        Arguments.of(2, Movie.REGULAR, 2),
        Arguments.of(3, Movie.REGULAR, 3.5),
        Arguments.of(6, Movie.REGULAR, 8),
        Arguments.of(0, Movie.NEW_RELEASE, 0),
        Arguments.of(1, Movie.NEW_RELEASE, 3),
        Arguments.of(2, Movie.NEW_RELEASE, 6),
        Arguments.of(0, Movie.CHILDRENS, 1.5),
        Arguments.of(3, Movie.CHILDRENS, 1.5),
        Arguments.of(4, Movie.CHILDRENS, 3));
  }

  @ParameterizedTest
  @MethodSource("provideCharges")
  void getCharge(int duration, int movieType, double expectedCharge) {
    assertEquals(expectedCharge, new Movie("", movieType).getCharge(duration));
  }
}
