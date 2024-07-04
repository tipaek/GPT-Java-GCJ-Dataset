import java.io.*;
import java.util.*;

public class Solution {

    private static final int TEN9 = 1000000000;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int testCases = scanner.nextInt();
        int U = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.println("Case #" + i + ": " + solve(scanner, U));
        }
    }

    private static String solve(Scanner scanner, int U) {
        Set<Character> allChars = new HashSet<>();
        Map<Integer, Set<Character>> digitToFirstCharMap = new HashMap<>();

        for (int i = 0; i < 10000; i++) {
            long value = scanner.nextLong();
            String str = scanner.next();
            if (allChars.size() < 10) {
                addCharsToSet(allChars, str);
            }
            if (value != -1 && String.valueOf(value).length() == str.length()) {
                digitToFirstCharMap.computeIfAbsent(getFirstDigit(value), k -> new HashSet<>())
                                   .add(str.charAt(0));
            }
        }

        Map<Integer, Character> digitToCharMap = new HashMap<>();
        Set<Character> knownChars = new HashSet<>();

        for (int digit = 1; digit < 10; digit++) {
            if (digitToFirstCharMap.containsKey(digit)) {
                Set<Character> possibleChars = digitToFirstCharMap.get(digit);
                Character selectedChar = selectChar(possibleChars, knownChars);
                digitToCharMap.put(digit, selectedChar);
                knownChars.add(selectedChar);
            }
        }

        digitToCharMap.put(0, selectChar(allChars, knownChars));
        char[] result = new char[10];
        for (int i = 0; i < 10; i++) {
            result[i] = digitToCharMap.get(i);
        }

        return new String(result);
    }

    private static void addCharsToSet(Set<Character> charSet, String str) {
        for (char c : str.toCharArray()) {
            charSet.add(c);
        }
    }

    private static Character selectChar(Set<Character> possibleChars, Set<Character> knownChars) {
        for (Character c : possibleChars) {
            if (!knownChars.contains(c)) {
                return c;
            }
        }
        return null;
    }

    private static int getFirstDigit(long value) {
        return Character.digit(String.valueOf(value).charAt(0), 10);
    }
}