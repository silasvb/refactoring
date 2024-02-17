package org.silasvb.refactoring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class NewReleaseTest {

  private Movie movie;

  @BeforeEach
  void setUp() {
    movie = Movie.newNewRelease("");
  }

  private static Stream<Arguments> provideCharges() {
    return Stream.of(Arguments.of(0, 0), Arguments.of(1, 3), Arguments.of(2, 6));
  }

  @ParameterizedTest
  @MethodSource("provideCharges")
  void getChargeTest(int duration, double expectedCharge) {
    assertEquals(expectedCharge, movie.getCharge(duration));
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1})
  void getFrequentRenterPointsForShortDurationTest(int duration) {
    assertEquals(1, movie.getFrequentRenterPoints(duration));
  }

  @ParameterizedTest
  @ValueSource(ints = {2, 5})
  void getFrequentRenterPointsFor2OrMoreDaysTest(int duration) {
    assertEquals(2, new NewRelease("").getFrequentRenterPoints(duration));
  }
}
