package cj2020.q.q2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


// https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020993c?show=progress
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; i++) {
            int[] a = toIntArray(in.nextLine());
            String[] answer = solve(a);
            System.out.println("Case #" + i + ": " + (String.join(" ", answer)));
        }
    }

    static String[] solve(int[] a) {

        List<String> result = new ArrayList<>();

        int currentDepth = 0;
        int n = a.length;

        while(currentDepth < a[0]) {
            currentDepth++;
            result.add("(");
        }

        for(int i = 0; i < a.length; i++) {
            result.add(Integer.toString(a[i]));

            if (i < n - 1 && currentDepth < a[i+1]) {
                currentDepth++;
                result.add("(");
            }
            if ((i < n - 1 && a[i+1] < currentDepth)) {
                currentDepth--;
                result.add(")");
            }
        }

        while (currentDepth > 0) {
            currentDepth--;
            result.add(")");
        }

        return new String[] { String.join("", result) };
    }

    private static String[] convertIntArrayToString(int[] a) {
        return new String[] { String.join("", Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining())) };
    }

    private static int[] toIntArray(String line) {
        String[] a = line.split("");
        return Arrays.stream(a).mapToInt(Integer::parseInt).toArray();
    }
}

