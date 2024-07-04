

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
            List<String> list = split(s, 0);
            String result = list.stream().map(ss -> change(ss, 0)).collect(Collectors.joining());
            String answer = "Case #" + (i + 1) + ": " + result;
            out.write(answer);
            out.newLine();
        }
        in.close();
        out.close();

    }

    static String solve(String s) {
        List<String> list = split(s, 0);
        return null;
    }

    static String change(String s, int value){
        char c = (char) ('0' + value);
        int i = 0;
        while (i < s.length() && s.charAt(i) ==c) {
            i++;
        }
        if (i == 0) {
            return "(" + s + ")";
        } else if (i == s.length()) {
            return s;
        } else {
            return s.substring(0, i) + "(" + s.substring(i) + ")";
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