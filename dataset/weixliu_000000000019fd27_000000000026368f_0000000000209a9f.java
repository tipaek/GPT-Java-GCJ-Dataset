package com.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String... args) {
        Scanner cin = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int num = cin.nextInt();
        cin.nextLine();
        for (int i = 0; i < num; i++) {
            String line = cin.nextLine();
            System.out.println(String.format("Case #%d: %s", i + 1, solve(line)));
        }
    }

    public static String solve(String line) {
        int[] a = new int[line.length()];
        for (int i = 0; i < line.length(); i++) {
            a[i] = line.charAt(i) - '0';
        }
        StringBuilder sb = helper(a, 0, line.length() - 1);
        int j = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '*') {
                sb.setCharAt(i, line.charAt(j++));
            }
        }
        return sb.toString();
    }

    public static StringBuilder helper(int[] a, int l, int r) {
        StringBuilder sb = new StringBuilder();
        if(l == r) {
            for(int i = 0;i < a[l];i++) {
                sb.append('(');
            }
            sb.append('*');
            for(int i = 0;i < a[l];i++) {
                sb.append(')');
            }
            return sb;
        }
        int i = l;
        while(i <= r) {
            while(i <= r && a[i] == 0) {
                sb.append('*');
                i++;
            }
            int start = i;
            if(i > r) {
                break;
            }
            sb.append('(');
            while(i <= r && a[i] != 0) {
                a[i++]--;
            }
            int end = i - 1;
            sb.append(helper(a, start, end));
            sb.append(')');
        }
        return sb;
    }
}
