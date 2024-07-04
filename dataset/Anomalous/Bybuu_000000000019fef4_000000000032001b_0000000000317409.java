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
            int flagged = 0;
            StringBuilder result = new StringBuilder("          ");

            while (flagged < 2) {
                System.out.println(10);
                scanner.nextLine();  // Consume the newline character
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                String ri = parts[1];

                if (ri.length() == 2) {
                    charMap.put(ri.charAt(1), 1);
                    charMap.put(ri.charAt(0), 0);
                    flagged = 2;
                }
            }

            while (flagged < 10) {
                System.out.print((flagged + 9));
                scanner.nextLine();  // Consume the newline character
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                String ri = parts[1];

                if (ri.length() == 2 && !charMap.containsKey(ri.charAt(1))) {
                    charMap.put(ri.charAt(1), flagged);
                    flagged++;
                }
            }

            for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
                char currentChar = entry.getKey();
                int index = entry.getValue();
                result.setCharAt(index, currentChar);
            }

            System.out.println(result);
        }
    }
}