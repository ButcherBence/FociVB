package hu.progmatic.PrimeTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {
    @Test
    void is2Prime() {
        boolean digit0 = Prime.isPrime(2);
        assertTrue(digit0);
    }
    @Test
    void is13Prime() {
        boolean digit0 = Prime.isPrime(13);
        assertTrue(digit0);
    }
    @Test
    void is199Prime() {
        boolean digit0 = Prime.isPrime(199);
        assertTrue(digit0);
    }
    @Test
    void is101Prime() {
        boolean digit0 = Prime.isPrime(101);
        assertTrue(digit0);
    }
    @Test
    void is1Prime() {
        boolean digit0 = Prime.isPrime(1);
        assertFalse(digit0);
    }
    @Test
    void is25Prime() {
        boolean digit0 = Prime.isPrime(25);
        assertFalse(digit0);
    }
    @Test
    void is4Prime() {
        boolean digit0 = Prime.isPrime(4);
        assertFalse(digit0);
    }
    @Test
    void is54Prime() {
        boolean digit0 = Prime.isPrime(54);
        assertFalse(digit0);
    }
}