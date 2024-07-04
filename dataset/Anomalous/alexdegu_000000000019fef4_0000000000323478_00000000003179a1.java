import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int u = scanner.nextInt();
            HashMap<Character, Integer> charToMinDigitMap = new HashMap<>();
            boolean allDigitsFound = false;

            for (int i = 0; i < Math.pow(10, 4); i++) {
                long m = scanner.nextLong();
                String s = scanner.next();

                char firstChar = s.charAt(0);
                int minDigit = charToMinDigitMap.getOrDefault(firstChar, 10);
                int firstDigitOfM = Integer.parseInt(Long.toString(m).substring(0, 1));

                if (minDigit > firstDigitOfM && s.length() == u) {
                    charToMinDigitMap.put(firstChar, firstDigitOfM);
                }

                if (!allDigitsFound) {
                    for (int j = 1; j < s.length(); j++) {
                        char currentChar = s.charAt(j);
                        charToMinDigitMap.putIfAbsent(currentChar, 10);
                    }
                }

                if (charToMinDigitMap.size() == 10) {
                    allDigitsFound = true;
                }
            }

            Character[] result = new Character[10];
            for (Map.Entry<Character, Integer> entry : charToMinDigitMap.entrySet()) {
                if (entry.getValue() == 10) {
                    result[0] = entry.getKey();
                } else {
                    result[entry.getValue()] = entry.getKey();
                }
            }

            StringBuilder resultString = new StringBuilder();
            for (Character ch : result) {
                resultString.append(ch);
            }

            System.out.println("Case #" + caseNum + ": " + resultString.toString());
        }
    }
}