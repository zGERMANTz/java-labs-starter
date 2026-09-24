package edu.course.lab01;

/**
 * Небольшие методы для первой лабораторной работы.
 */
public final class CourseToolkit {

    private CourseToolkit() {
        // Утилитарный класс не должен иметь экземпляров.
    }


    /**
     * Возвращает true, если число четное.
     *
     * @param number число для проверки
     * @return true, если число делится на 2 без остатка
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }


    /**
     * Проверяет, является ли число простым.
     *
     * Простое число имеет только два делителя:
     * 1 и само число.
     *
     * @param number число для проверки
     * @return true, если число простое, иначе false
     */
    public static boolean isPrime(int number) {

        // Числа меньше 2 не являются простыми.
        if (number < 2) {
            return false;
        }


        // Достаточно проверить делители до квадратного корня числа.
        for (int divisor = 2;
             divisor * divisor <= number;
             divisor++) {

            if (number % divisor == 0) {
                return false;
            }
        }


        return true;
    }


    /**
     * Проверяет, является ли строка палиндромом.
     *
     * Регистр символов и пробелы учитываются.
     *
     * @param text строка для проверки
     * @return true, если строка является палиндромом, иначе false
     */
    public static boolean isPalindrome(String text) {

        if (text == null) {
            throw new IllegalArgumentException();
        }


        int left = 0;
        int right = text.length() - 1;


        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }


        return true;
    }

    /**
     * Вычисляет среднее арифметическое элементов массива.
     *
     * @param values массив чисел
     * @return среднее значение элементов массива
     */
    public static double average(int[] values) {

        if (values == null || values.length == 0) {
            throw new IllegalArgumentException();
        }


        int sum = 0;


        for (int value : values) {
            sum += value;
        }


        return (double) sum / values.length;
    }
}