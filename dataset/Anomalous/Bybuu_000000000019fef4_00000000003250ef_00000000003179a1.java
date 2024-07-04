import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int U = scanner.nextInt();
            Map<Character, Integer> charMap = new HashMap<>();
            int uniqueCharsCount = 0;
            StringBuilder result = new StringBuilder("          ");
            scanner.nextLine();

            while (uniqueCharsCount < 9) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (!parts[0].equals("-1")) {
                    String numberPart = parts[0];
                    int number = Integer.parseInt(numberPart);
                    String response = parts[1];

                    if (number <= (uniqueCharsCount + 1) * 10 + 9) {
                        if (response.length() == 2 && !charMap.containsKey(response.charAt(0))) {
                            charMap.put(response.charAt(0), uniqueCharsCount + 1);
                            uniqueCharsCount++;
                        }
                    }
                }
            }

            while (uniqueCharsCount < 10) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (!parts[0].equals("-1")) {
                    String response = parts[1];
                    if (response.length() == 2 && !charMap.containsKey(response.charAt(1))) {
                        charMap.put(response.charAt(1), 0);
                        uniqueCharsCount++;
                    }
                }
            }

            for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
                char currentChar = entry.getKey();
                int index = entry.getValue();
                result.setCharAt(index, currentChar);
            }

            System.out.println("Case #" + (t + 1) + ": " + result.toString());
        }
    }
}