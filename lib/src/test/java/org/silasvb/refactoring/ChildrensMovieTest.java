package org.silasvb.refactoring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ChildrensMovieTest {

  private Movie movie;

  @BeforeEach
  void setUp() {
    movie = Movie.newChildrensMovie("");
  }

  private static Stream<Arguments> provideCharges() {
    return Stream.of(Arguments.of(0, 1.5), Arguments.of(3, 1.5), Arguments.of(4, 3));
  }

  @ParameterizedTest
  @MethodSource("provideCharges")
  void getChargeTest(int duration, double expectedCharge) {
    assertEquals(expectedCharge, movie.getCharge(duration));
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 5})
  void getFrequentRenterPointsTest(int duration) {
    assertEquals(1, movie.getFrequentRenterPoints(duration));
  }
}
