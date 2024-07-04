import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Map<String, String> digitLetterMap = createDigitLetterMap();

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < testCases; t++) {
            String inputLine = scanner.nextLine();
            String result = processLine(inputLine, digitLetterMap);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static Map<String, String> createDigitLetterMap() {
        Map<String, String> digitLetterMap = new HashMap<>();
        digitLetterMap.put("1", "A");
        digitLetterMap.put("2", "B");
        digitLetterMap.put("3", "C");
        digitLetterMap.put("4", "D");
        digitLetterMap.put("5", "E");
        digitLetterMap.put("6", "F");
        digitLetterMap.put("7", "G");
        digitLetterMap.put("8", "H");
        digitLetterMap.put("9", "I");
        digitLetterMap.put("A", "1");
        digitLetterMap.put("B", "2");
        digitLetterMap.put("C", "3");
        digitLetterMap.put("D", "4");
        digitLetterMap.put("E", "5");
        digitLetterMap.put("F", "6");
        digitLetterMap.put("G", "7");
        digitLetterMap.put("H", "8");
        digitLetterMap.put("I", "9");
        return digitLetterMap;
    }

    private static String processLine(String line, Map<String, String> digitLetterMap) {
        String result = line;
        int length = line.length();

        for (int digit = 1; digit <= 9; digit++) {
            String strDigit = Integer.toString(digit);
            for (int i = length - 1; i >= 0; i--) {
                String current = generateRepeatedString(length + 1, strDigit);
                result = result.replace(current, generateRepeatedString(digit, "(") + generateRepeatedString(length + 1, digitLetterMap.get(strDigit)) + generateRepeatedString(digit, ")"));
            }
            length = line.length();
        }

        return result.replace("A", "1")
                     .replace("B", "2")
                     .replace("C", "3")
                     .replace("D", "4")
                     .replace("E", "5")
                     .replace("F", "6")
                     .replace("G", "7")
                     .replace("H", "8")
                     .replace("I", "9");
    }

    private static String generateRepeatedString(int length, String character) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}