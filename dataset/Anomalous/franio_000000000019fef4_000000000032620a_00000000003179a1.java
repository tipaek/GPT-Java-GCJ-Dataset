package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();
        for (long i = 0; i < t; i++) {
            int U = scanner.nextInt();
            long max = Long.parseLong(String.join("", Collections.nCopies(U, "9")));
            DString dString = new DString();
            for (long j = 0; j < 10000; j++) {
                long Q = scanner.nextLong();
                String R = scanner.next();
                if (Q == -1) {
                    dString.add(R, max);
                }
                dString.add(R, Q);
            }
            String result = dString.constructString();
            printResult(i, result);
        }
        scanner.close();
    }

    private static void printResult(long caseNumber, String result) {
        System.out.println("Case #" + (caseNumber + 1) + ": " + result);
    }
}

class DString {
    private Map<Integer, CharPossibilities> possibilities = new HashMap<>();
    private Set<Character> allChars = new HashSet<>();

    DString() {
        for (int i = 0; i <= 9; i++) {
            possibilities.put(i, new CharPossibilities());
        }
    }

    public String constructString() {
        char[] result = new char[10];
        while (!allChars.isEmpty()) {
            for (int i = 0; i < 10; i++) {
                CharPossibilities charPossibilities = possibilities.get(i);
                if (charPossibilities.canBe.size() + 1 == allChars.size()) {
                    char identifiedChar = 0;
                    for (char c : allChars) {
                        if (!charPossibilities.canBe.containsKey(c)) {
                            result[i] = c;
                            identifiedChar = c;
                            break;
                        }
                    }
                    allChars.remove(identifiedChar);
                }
            }
        }
        return new String(result);
    }

    public void add(String R, long Q) {
        String qString = Long.toString(Q);
        boolean isFirstChar = true;
        for (char c : R.toCharArray()) {
            if (allChars.size() < 10) {
                allChars.add(c);
            }
            if (isFirstChar) {
                possibilities.get(0).canBe.put(c, false);
                isFirstChar = false;
                if (R.length() == qString.length()) {
                    int firstDigit = Character.getNumericValue(qString.charAt(0));
                    for (int i = firstDigit + 1; i <= 9; i++) {
                        possibilities.get(i).canBe.put(c, false);
                    }
                }
            }
        }
    }
}

class CharPossibilities {
    Map<Character, Boolean> canBe = new HashMap<>();
}