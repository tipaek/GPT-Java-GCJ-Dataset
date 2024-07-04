import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String []args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCount = in.nextInt();
        for (int testNumber = 1; testNumber <= testCount; testNumber++) {
            int n = in.nextInt();

            List<String> firstSizePatterns = new ArrayList<>(n);
            List<String> secondSizePatterns = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                String pattern = in.next();

                if (pattern.charAt(0) == '*') {
                    secondSizePatterns.add(pattern.substring(1));
                } else if (pattern.charAt(pattern.length() - 1) == '*') {
                    firstSizePatterns.add(pattern.substring(0, pattern.length() - 1));
                } else {
                    String []splits = pattern.split("\\*");
                    firstSizePatterns.add(splits[0]);
                    secondSizePatterns.add(splits[1]);
                }
            }

            firstSizePatterns.sort(Comparator.comparingInt(String::length));
            secondSizePatterns.sort(Comparator.comparingInt(String::length));

            if (canSolveItWithBoth(firstSizePatterns, secondSizePatterns)) {

                String solution = generateSolution(firstSizePatterns, secondSizePatterns);

                System.out.printf("Case #%d: %s\n", testNumber, solution);
            } else {
                System.out.printf("Case #%d: *\n", testNumber);
            }

//                for (String s: firstSizePatterns) {
//                    System.out.println(s);
//                }
//                System.out.println("------");
//                for (String s: secondSizePatterns) {
//                    System.out.println(s);
//                }
        }
    }

    private static String generateSolution(List<String> firstSizePatterns, List<String> secondSizePatterns) {
        if (firstSizePatterns.isEmpty()) {
            return secondSizePatterns.get(secondSizePatterns.size() - 1);
        }
        if (secondSizePatterns.isEmpty()) {
            return firstSizePatterns.get(firstSizePatterns.size() - 1);
        }
        return firstSizePatterns.get(firstSizePatterns.size() - 1) + secondSizePatterns.get(secondSizePatterns.size() - 1);
    }

    private static boolean canSolveItWithBoth(List<String> firstSizePatterns, List<String> secondSizePatterns) {
        return canSolveIt(secondSizePatterns) && canSolveItBackwards(firstSizePatterns);
    }

    private static boolean canSolveIt(List<String> patterns) {
        if (patterns.isEmpty()) return true;

        String lastWord = patterns.get(patterns.size() - 1);
        for (int i = 0; i < patterns.size() - 1; i++) {
            String word = patterns.get(i);
            String wordToMatch = lastWord.substring(lastWord.length() - word.length());

//            System.out.printf("comparing %s == %s | %s\n", word, wordToMatch, lastWord);

            if (!word.equals(wordToMatch)) {
                return false;
            }
        }

        return true;
    }

    private static boolean canSolveItBackwards(List<String> patterns) {
        if (patterns.isEmpty()) return true;

        String lastWord = patterns.get(patterns.size() - 1);

        for (int i = 0; i < patterns.size() - 1; i++) {
            String word = patterns.get(i);
            String wordToMatch = lastWord.substring(0, word.length());

//            System.out.printf("[comparing] %s == %s | %s\n", word, wordToMatch, lastWord);

            if (!word.equals(wordToMatch)) {
                return false;
            }
        }

        return true;
    }
}
/*
1
7
abcdep*yz
ab*yz
abc*xyz
*wxyz
abcdepf*
ab*
*z

2
5
*CONUTS
*COCONUTS
*OCONUTS
*CONUTS
*S
2
*XZ
*XYZ

Case #1: COCONUTS
Case #2: *



* */