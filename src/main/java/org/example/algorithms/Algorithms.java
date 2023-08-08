package org.example.algorithms;

import java.util.Arrays;
import java.util.List;

public class Algorithms {
    public static void main(String[] args) {
        long n = 999_999_999;
        double init = System.currentTimeMillis();
        System.out.println(String.format("Alg.rameshFindSum(%s) = ", n) + Algorithms.rameshFindSum(n));
        System.out.println("Time taken: " + (System.currentTimeMillis() - init) + " milliseconds");
        double init1 = System.currentTimeMillis();
        System.out.println(String.format("Alg.sureshFindSum(%s) = ", n) + Algorithms.sureshFindSum(n));
        System.out.println("Time taken: " + (System.currentTimeMillis() - init1) + " milliseconds");

        int[] arr = {1, 3, 5, 2};
        System.out.println(String.format("Algorithms.findMissingNumber(%s) = %s", Arrays.toString(arr), Algorithms.findMissingNumber(arr)));

        List.of("that", "ovo", "ama", "paap").forEach(word -> System.out.printf("Is the word \"%s\" a palindrome? %s%n", word, Algorithms.isPalindrome(word)));
    }

    public static long rameshFindSum(long n) {
        return n * (n + 1) / 2;
    }

    public static long sureshFindSum(long n) {
        long sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int sum = n * (n + 1) / 2;
        for (int num : arr) {
            sum = sum - num;
        }
        return sum;
    }

    public static boolean isPalindrome(String word) {
        char[] chars = word.toCharArray();
        int init = 0;
        int end = word.length() - 1;
        while (init < end) {
            if (chars[init] != chars[end]) return false;
            init++;
            end--;
        }
        return true;
    }
}
