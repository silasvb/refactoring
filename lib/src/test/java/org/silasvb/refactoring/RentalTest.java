package org.silasvb.refactoring;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RentalTest {

  @Test
  void getChargeTest() {
    Movie movie = mock(Movie.class);
    double charge = 35.0;
    when(movie.getCharge(any())).thenReturn(charge);
    Rental rental = new Rental(movie, 2);

    assertEquals(charge, rental.getCharge());
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
  void getRentalPoints(int duration, int movieType, int expectedRentalPoints) {
  }
}
