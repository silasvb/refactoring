package org.silasvb.refactoring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class RegularMovieTest {

  private static Stream<Arguments> provideCharges() {
    return Stream.of(
        Arguments.of(0, 2), Arguments.of(1, 2), Arguments.of(3, 3.5), Arguments.of(6, 8));
  }

  @ParameterizedTest
  @MethodSource("provideCharges")
  void getChargeTest(int duration, double expectedCharge) {
    assertEquals(expectedCharge, new RegularMovie("").getCharge(duration));
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 5})
  void getFrequentRenterPointsTest(int duration) {
    assertEquals(1, new RegularMovie("").getFrequentRenterPoints(duration));
  }
}
