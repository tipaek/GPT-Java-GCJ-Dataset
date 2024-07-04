// package joohoyo.y2020.codejam;

// https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020993c?show=progress
// 19:55 ~  (min)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.start();
    }

    // public static void main(String[] args) {
    //     NestingDepth n = new NestingDepth();
    //     n.start();
    // }

    private void start() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();
            String answer = solution(s);
            String output = "Case #" + i + ": " + answer;
            System.out.println(output);
        }
    }

    String solution(String s) {
        s += "0";
        String answer = "";
        int lastNumber = 0;
        int opendCount = 0;
        for (int i = 0; i < s.length(); i++) {
            int number = Integer.parseInt(s.substring(i, i + 1));
            if (number == lastNumber) {
                answer += number;
                continue;
            }
            if (opendCount < number) {
                answer += repeat("(", number - opendCount) + number;
            } else {
                answer += repeat(")", opendCount - number) + number;
            }
            opendCount = number;
            lastNumber = number;
        }

        return answer.substring(0, answer.length() - 1);
    }

    private String repeat(String str, int count) {
        String r = "";
        for (int i = 0; i < count; i++) {
            r += str;
        }
        return r;
    }

}

