package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseToolkitTest {


    @Test
    void returnsTrueForEvenNumber() {

        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }


    @Test
    void returnsFalseForOddNumber() {

        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }


    @Test
    void returnsTrueForNegativeEvenNumber() {

        boolean result = CourseToolkit.isEven(-8);

        assertTrue(result);
    }


    @Test
    void returnsTrueForPrimeNumber() {

        boolean result = CourseToolkit.isPrime(13);

        assertTrue(result);
    }


    @Test
    void returnsTrueForTwo() {

        boolean result = CourseToolkit.isPrime(2);

        assertTrue(result);
    }


    @Test
    void returnsFalseForCompositeNumber() {

        boolean result = CourseToolkit.isPrime(12);

        assertFalse(result);
    }


    @Test
    void returnsFalseForSquareOfPrime() {

        boolean result = CourseToolkit.isPrime(49);

        assertFalse(result);
    }


    @Test
    void returnsFalseForNumberLessThanTwo() {

        boolean result = CourseToolkit.isPrime(1);

        assertFalse(result);
    }


    @Test
    void returnsTrueForPalindrome() {

        boolean result = CourseToolkit.isPalindrome("level");

        assertTrue(result);
    }


    @Test
    void returnsFalseWhenCaseIsDifferent() {

        boolean result = CourseToolkit.isPalindrome("Level");

        assertFalse(result);
    }


    @Test
    void spacesAreSignificant() {

        boolean result = CourseToolkit.isPalindrome("a a");

        assertTrue(result);
    }


    @Test
    void nullThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.isPalindrome(null)
        );
    }


    @Test
    void emptyStringIsPalindrome() {

        boolean result = CourseToolkit.isPalindrome("");

        assertTrue(result);
    }


    @Test
    void returnsAverageValue() {

        int[] values = {2, 4, 6};

        double result = CourseToolkit.average(values);

        assertEquals(4.0, result);
    }


    @Test
    void worksWithNegativeNumbers() {

        int[] values = {-2, -4, -6};

        double result = CourseToolkit.average(values);

        assertEquals(-4.0, result);
    }


    @Test
    void nullArrayThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.average(null)
        );
    }


    @Test
    void emptyArrayThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> CourseToolkit.average(new int[]{})
        );
    }


    @Test
    void returnsFractionalAverage() {

        int[] values = {1, 2};

        double result = CourseToolkit.average(values);

        assertEquals(1.5, result);
    }


    @Test
    void averageDoesNotModifyArray() {

        int[] values = {1, 2, 3};

        CourseToolkit.average(values);

        assertEquals(1, values[0]);
        assertEquals(2, values[1]);
        assertEquals(3, values[2]);
    }
}