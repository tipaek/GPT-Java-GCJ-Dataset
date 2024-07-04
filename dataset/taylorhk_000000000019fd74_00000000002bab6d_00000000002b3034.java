// package com.taylorc.codejam1a2020;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int caseCnt = s.nextInt();
        s.nextLine();

        for (int i = 0; i < caseCnt; i++) {
            int size = s.nextInt();
            s.nextLine();
            List<String> patterns = new ArrayList<>();
            String maxWord = "";
            for (int p = 0; p < size; p++) {
                String curr = s.nextLine();
                String word = curr.replaceAll("\\*","");
                String pattern = curr.replaceAll("\\*", "\\.*");
                if (word.length() > maxWord.length()) maxWord = word;
                patterns.add(pattern);
            }
            boolean match = true;

            for (int p = 0; p < size; p++) {
                String pPattern = patterns.get(p);
                System.out.println("pPatern: " + pPattern);

                Pattern pattern = Pattern.compile(pPattern);
                Matcher m = pattern.matcher(maxWord);
                if (!m.matches()) {
                    match = false;
                    break;
                }
            }
            if (match) {
                System.out.println("Case #" + (i + 1) + ": " + maxWord);
            } else {
                System.out.println("Case #" + (i + 1) + ": " + "*");
            }

        }
    }
}
