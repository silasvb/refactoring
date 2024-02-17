package org.silasvb.refactoring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class CustomerTest {

  @Test
  void multipleMovieTest() {
    Customer customerUnderTest = getCustomerUnderTest();
    String result = customerUnderTest.statement();

    String expected =
        """
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

    String expected =
        """
            <H1>Rentals for <EM>SOME CUSTOMER</EM></H1><P>
            T1: 2.0<BR>
            T2: 2.0<BR>
            <P> You owe me <EM>4.0</EM><P>
            On this rental you earned <EM>2</EM> frequent renter points<P>""";

    assertEquals(expected, result);
  }

  private static Customer getCustomerUnderTest() {
    Movie movie1 = mock(Movie.class);
    when(movie1.getTitle()).thenReturn("T1");
    Rental rental1 = mock(Rental.class);
    when(rental1.getCharge()).thenReturn(2.0);
    when(rental1.getFrequentRenterPoints()).thenReturn(1);
    when(rental1.getMovie()).thenReturn(movie1);

    Movie movie2 = mock(Movie.class);
    when(movie2.getTitle()).thenReturn("T2");
    Rental rental2 = mock(Rental.class);
    when(rental2.getCharge()).thenReturn(2.0);
    when(rental2.getFrequentRenterPoints()).thenReturn(1);
    when(rental2.getMovie()).thenReturn(movie2);

    String customerName = "SOME CUSTOMER";
    Customer customerUnderTest = new Customer(customerName);
    customerUnderTest.addRental(rental1);
    customerUnderTest.addRental(rental2);
    return customerUnderTest;
  }
}
