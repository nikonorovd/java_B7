package ru.stqa.d7.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

  @Test
  public void testPrime(){
    Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
  }
  @Test(enabled = false)
  public void testPrimeLong(){
    long n = Integer.MAX_VALUE - 2;
    Assert.assertFalse(Primes.isPrime(n));
  }

  @Test
  public void testNonPrime(){
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
  }


}

