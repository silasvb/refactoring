package org.silasvb.refactoring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RentalTest {

    private static Stream<Arguments> provideNewReleaseCharges() {
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
    @MethodSource("provideNewReleaseCharges")
    void getChargeTest(int duration, double expectedAmount, int movieType) {
        Rental rental = new Rental(new Movie("", movieType), duration);
        assertEquals(expectedAmount, rental.getCharge());
    }
}