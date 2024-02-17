package org.silasvb.refactoring;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CustomerTest {

  private static Stream<Arguments> provideSingleMovieData() {
    return Stream.of(
        Arguments.of(0, Movie.REGULAR, 1),
        Arguments.of(2, Movie.REGULAR, 1),
        Arguments.of(3, Movie.REGULAR, 1),
        Arguments.of(6, Movie.REGULAR, 1),
        Arguments.of(0, Movie.NEW_RELEASE, 1),
        Arguments.of(1, Movie.NEW_RELEASE, 1),
        Arguments.of(2, Movie.NEW_RELEASE, 2),
        Arguments.of(0, Movie.CHILDRENS, 1),
        Arguments.of(3, Movie.CHILDRENS, 1),
        Arguments.of(4, Movie.CHILDRENS, 1));
  }

  @ParameterizedTest
  @MethodSource("provideSingleMovieData")
  void singleMovieTest(int daysRented, int movieType, int renterPoints) {
    String title = "<SOME MOVIE TITLE>";

    Movie movie = new Movie(title, movieType);
    Rental rental = new Rental(movie, daysRented);

    String cutomerName = "<SOME CUSTOMER>";
    Customer customerUnderTest = new Customer(cutomerName);
    customerUnderTest.addRental(rental);

    String result = customerUnderTest.statement();
    assertTrue(result.contains("Rental Record for <SOME CUSTOMER>"));
    assertTrue(result.contains("\t<SOME MOVIE TITLE>\t"));
    assertTrue(result.contains("Amount owed is "));
    assertTrue(result.contains("You earned " + renterPoints + " frequent renter points"));
  }

  @Test
  public void multipleMovieTest() {
    Movie movie1 = new Movie("<T1>", Movie.REGULAR);
    Rental rental1 = new Rental(movie1, 2);
    Movie movie2 = new Movie("<T2>", Movie.REGULAR);
    Rental rental2 = new Rental(movie2, 1);

    String cutomerName = "<SOME CUSTOMER>";
    Customer customerUnderTest = new Customer(cutomerName);
    customerUnderTest.addRental(rental1);
    customerUnderTest.addRental(rental2);

    String result = customerUnderTest.statement();
    assertTrue(result.contains("\t<T1>\t2.0"));
    assertTrue(result.contains("\t<T2>\t2.0"));
  }
}
