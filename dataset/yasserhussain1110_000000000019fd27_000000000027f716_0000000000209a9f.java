// package com.yasser.twenty20.nesting;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Solution {
    public static void main(String[] args) {
        new Solution().test();
    }

    public void test() {
        Scanner scanner = new Scanner(in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            out.print(String.format("Case #%s: ", i + 1));
            solve(scanner.next());
            out.println();
        }
    }

    private void solve(String num) {
        int count = 1;
        for (int i = 0; i < num.length() - 1; i++) {
            if (num.charAt(i) == num.charAt(i + 1)) {
                count++;
            } else {
                print(num.charAt(i), count);
                count = 1;
            }
        }

        print(num.charAt(num.length() - 1), count);
    }

    private void print(char c, int count) {
        for (int i = 0; i < c - '0'; i++) {
            out.print('(');
        }
        for (int i = 0; i < count; i++) {
            out.print(c);
        }
        for (int i = 0; i < c - '0'; i++) {
            out.print(')');
        }
    }
}
