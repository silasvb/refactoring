package org.silasvb.refactoring;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class RentalTest {

  @Test
  void getChargeTest() {
    Movie movie = mock(Movie.class);
    double charge = 35.0;
    when(movie.getCharge(anyInt())).thenReturn(charge);
    Rental rental = new Rental(movie, 2);

    assertEquals(charge, rental.getCharge());
  }

  @Test
  void getRentalPoints() {
    Movie movie = mock(Movie.class);
    int rentalPoints = 3;
    when(movie.getFrequentRenterPoints(anyInt())).thenReturn(rentalPoints);
    Rental rental = new Rental(movie, 3);

    assertEquals(rentalPoints, rental.getFrequentRenterPoints());
  }
}
