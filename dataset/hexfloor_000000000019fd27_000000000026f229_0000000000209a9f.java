

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 0; i < t; ++i) {
            String s = in.nextLine();
            String result  = solve(s, 0);
            String answer = "Case #" + (i + 1) + ": " + result;
            out.write(answer);
            out.newLine();
        }
        in.close();
        out.close();

    }

    static String solve(String s, int value) {
        if (value == 9) {
            return s;
        }
        List<String> list = split(s, value);
        return list.stream().map(ss -> change(ss, value)).collect(Collectors.joining());
    }

    static String change(String s, int value) {
        char c = (char) ('0' + value);
        int i = 0;
        while (i < s.length() && s.charAt(i) == c) {
            i++;
        }
        if (i == 0) {
            return "(" + solve(s, value + 1) + ")";
        } else if (i == s.length()) {
            return s;
        } else {
            return s.substring(0, i) + "(" + solve(s.substring(i), value + 1) + ")";
        }
    }

    static List<String> split(String s, int value) {
        List<String> list = new ArrayList<>();
        char c = (char) ('0' + value);
        int i = 0;
        int start = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == c) {
                i++;
            }
            while (i < s.length() && s.charAt(i) != c) {
                i++;
            }
            list.add(s.substring(start, i));
            start = i;
        }
        return list;
    }


    static int[] toArray(String s) {
        return s.chars().map(i -> i - '0').toArray();
    }

}