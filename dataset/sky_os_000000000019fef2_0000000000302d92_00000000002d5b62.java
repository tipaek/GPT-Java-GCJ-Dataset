/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package codeJam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author namhcn
 */
public class Solution {

    private static final boolean DEBUG = false;

    public static String resolve(double a, double b) {
        int max = 0;
        double init = Math.abs(a) + Math.abs(b);
        while (init != 0) {
            if (init < 2) {
                break;
            }
            init = init / 2;
            max++;
        }
        String result = "";
        while (max != -1) {
            if (Math.abs(a) > Math.abs(b)) {
                if (a > 0) {
                    a = a - Math.pow(2, max);
                    result = "E" + result;
                } else {
                    a = a + Math.pow(2, max);
                    result = "W" + result;

                }
            } else {
                if (b > 0) {
                    b = b - Math.pow(2, max);
                    result = "N" + result;
                } else {
                    b = b + Math.pow(2, max);
                    result = "S" + result;
                }
            }
//            System.out.println((int)a + ":" + (int)b);
            max--;
        }
        if (a == 0 && b == 0) {
            return result;

        } else {
            return "IMPOSSIBLE";
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("resources/input1.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if (a % 2 == 0 && b % 2 == 0 || (a % 2 != 0 && b % 2 != 0)) {
                    System.out.println("Case #" + testNumber + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + testNumber + ": " + resolve(a, b));

                }

            }
        }
        // System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
//    6
//0 1
//0 3
//1 0
//1 4
//2 3
//3 4
//4
}
