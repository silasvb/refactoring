package org.silasvb.refactoring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NewReleaseTest {

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

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void getFrequentRenterPointsForShortDurationTest(int duration) {
        assertEquals(1, new NewRelease("").getFrequentRenterPoints(duration));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 5})
    void getFrequentRenterPointsFor2OrMoreDaysTest(int duration) {
        assertEquals(2, new NewRelease("").getFrequentRenterPoints(duration));
    }

}
