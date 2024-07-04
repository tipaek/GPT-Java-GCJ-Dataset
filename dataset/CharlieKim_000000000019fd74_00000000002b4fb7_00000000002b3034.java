package com.google.codejam.round1a.qa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = scanner.nextInt();

        for (int i = 0; i < numOfCases; i++) {
            List<String> pList = new ArrayList<>();
            int n = scanner.nextInt();
            for (int j=0; j<n; j++) {
                pList.add(scanner.next());
            }

            System.out.println("Case #" + (i + 1) + ": " + solve(pList));
        }
    }

    private static String solve(List<String> pList) {
        pList.sort(Comparator.comparingInt(String::length));
        Collections.reverse(pList);

        String first = pList.get(0);
        for (String item : pList) {
            if (!first.matches(item.replaceAll("\\*", "[A-Z*]*"))) {
                return "*";
            }
        }

        return first.replaceAll("\\*", "");
    }
}
