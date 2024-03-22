package org.example.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        System.out.printf("Algorithms.findMissingNumber(%s) = %s%n", Arrays.toString(arr), Algorithms.findMissingNumber(arr));

        List.of("that", "ovo", "ama", "paap").forEach(word -> System.out.printf("Is the word \"%s\" a palindrome? %s%n", word, Algorithms.isPalindrome(word)));

        Map<Integer, Double> cache = new HashMap<>();
        System.out.println("fib(8) = " + fib(200, cache));

        int[][] matrix = {
                {1, 2, 3, 4},
                {4, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        printSpiral(matrix, 4, 4);
    }

    public static long rameshFindSum(long n) {
        return n * (n + 1) / 2;
    }

    public static long sureshFindSum(long n) {
        long sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int sum = n * (n + 1) / 2;
        for (int num : arr) {
            sum -= num;
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

    public static double fib(int n, Map<Integer, Double> cache) {
        if (cache.containsKey(n)) return cache.get(n);
        double result;
        if (n <= 2) result = 1;
        else result = fib(n - 1, cache) + fib(n - 2, cache);
        cache.put(n, result);
        return result;
    }

    public static void printSpiral(int[][] matrix, int row, int col) {
        int i, k = 0, l = 0;
        while (k < row && l < col) {
            for (i = k; i < col; i++) {
                System.out.printf("%d ", matrix[k][i]);
            }
            k++;
            for (i = k; i < row; i++) {
                System.out.printf("%d ", matrix[i][col - 1]);
            }
            col--;
            if (k < row) {
                for (i = col - 1; i >= l; i--) {
                    System.out.printf("%d ", matrix[row - 1][i]);
                }
                row--;
            }
            if (l < col) {
                for (i = row - 1; i >= k; i--) {
                    System.out.printf("%d ", matrix[i][l]);
                }
                l++;
            }
        }
    }
}
