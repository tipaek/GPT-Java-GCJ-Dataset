import java.util.*;
import java.io.*;

public class Solution {
    static List<Long> list1;
    static List<String> list2;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);

        int testCases = in.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            list1 = new ArrayList<>();
            list2 = new ArrayList<>();

            int dataSize = in.nextInt();
            for (int i = 0; i < 10000; i++) {
                list1.add(in.nextLong());
                list2.add(in.next());
            }

            String result;
            if (list1.get(0) == -1) {
                result = solveCaseWithNegativeOne();
            } else {
                result = solveCaseWithoutNegativeOne();
            }
            out.printf("Case #%d: %s\n", caseNum, result);
        }

        out.close();
    }

    public static String solveCaseWithNegativeOne() {
        Set<Character> allCharacters = new HashSet<>();
        Set<Character> notZeroCharacters = new HashSet<>();

        for (String s : list2) {
            for (char c : s.toCharArray()) {
                allCharacters.add(c);
            }
            notZeroCharacters.add(s.charAt(0));
        }

        char[] result = new char[10];
        int index = 0;
        for (Character ch : allCharacters) {
            result[index++] = ch;
        }

        while (index < 10) {
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                if (!allCharacters.contains(ch)) {
                    result[index++] = ch;
                    allCharacters.add(ch);
                    break;
                }
            }
        }

        for (int i = 1; i < 10; i++) {
            if (!notZeroCharacters.contains(result[i])) {
                char temp = result[i];
                result[i] = result[0];
                result[0] = temp;
                break;
            }
        }

        return new String(result);
    }

    public static String solveCaseWithoutNegativeOne() {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            digits.add(i);
        }

        Map<Character, Set<Integer>> possibleDigits = new HashMap<>();
        int n = list1.size();

        for (int i = 0; i < n; i++) {
            String numberStr = list1.get(i).toString();
            String charStr = list2.get(i);

            for (char c : charStr.toCharArray()) {
                possibleDigits.computeIfAbsent(c, k -> new HashSet<>(digits));
            }

            char firstChar = charStr.charAt(0);
            if (numberStr.length() == charStr.length()) {
                for (int j = numberStr.charAt(0) - '0' + 1; j < 10; j++) {
                    possibleDigits.get(firstChar).remove(j);
                }
            }
            possibleDigits.get(firstChar).remove(0);
        }

        char[] result = solveDigits(possibleDigits);
        return new String(result);
    }

    public static char[] solveDigits(Map<Character, Set<Integer>> possibleDigits) {
        char[] result = new char[10];
        List<Character> keys = new ArrayList<>(possibleDigits.keySet());
        findValidDigits(possibleDigits, result, keys, 0);
        return result;
    }

    public static boolean findValidDigits(Map<Character, Set<Integer>> possibleDigits, char[] result, List<Character> keys, int pos) {
        if (pos == 10) {
            return isValid(result);
        }
        char currentChar = keys.get(pos);
        for (Integer digit : possibleDigits.get(currentChar)) {
            if (result[digit] == 0) {
                result[digit] = currentChar;
                if (findValidDigits(possibleDigits, result, keys, pos + 1)) {
                    return true;
                }
                result[digit] = 0;
            }
        }
        return false;
    }

    public static boolean isValid(char[] result) {
        Map<Character, Character> charToDigit = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            charToDigit.put(result[i], (char) (i + '0'));
        }

        int n = list1.size();
        for (int i = 0; i < n; i++) {
            long originalNumber = list1.get(i);
            String charStr = list2.get(i);
            char[] transformedChars = new char[charStr.length()];

            for (int j = 0; j < charStr.length(); j++) {
                transformedChars[j] = charToDigit.get(charStr.charAt(j));
            }

            long transformedNumber = Long.parseLong(new String(transformedChars));
            if (transformedNumber > originalNumber) {
                return false;
            }
        }

        return true;
    }
}