package org.silasvb.refactoring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CustomerTest {
  
  @Test
  void multipleMovieTest() {
    Customer customerUnderTest = getCustomerUnderTest();
    String result = customerUnderTest.statement();

    String expected = """
            Rental Record for SOME CUSTOMER
            \tT1\t2.0
            \tT2\t2.0
            Amount owed is 4.0
            You earned 2 frequent renter points""";

    assertEquals(expected, result);
  }

  @Test
  void htmlStatement() {
    Customer customerUnderTest = getCustomerUnderTest();
    String result = customerUnderTest.htmlStatement();

    String expected = """
            <H1>Rentals for <EM>SOME CUSTOMER</EM></H1><P>
            T1: 2.0<BR>
            T2: 2.0<BR>
            <P> You owe me <EM>4.0</EM><P>
            On this rental you earned <EM>2</EM> frequent renter points<P>""";

    assertEquals(expected, result);
  }

  private static Customer getCustomerUnderTest() {
    Movie movie1 = new Movie("T1", Movie.REGULAR);
    Rental rental1 = new Rental(movie1, 2);
    Movie movie2 = new Movie("T2", Movie.REGULAR);
    Rental rental2 = new Rental(movie2, 1);

    String customerName = "SOME CUSTOMER";
    Customer customerUnderTest = new Customer(customerName);
    customerUnderTest.addRental(rental1);
    customerUnderTest.addRental(rental2);
    return customerUnderTest;
  }

}
