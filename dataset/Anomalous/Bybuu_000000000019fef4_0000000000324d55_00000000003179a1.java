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
            int uniqueCount = 0;
            StringBuilder result = new StringBuilder("          ");
            scanner.nextLine(); // Consume the newline

            while (uniqueCount < 9) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (!parts[0].equals("-1")) {
                    String N = parts[0];
                    int ni = Integer.parseInt(N);
                    String ri = parts[1];
                    if (ni <= (uniqueCount + 1) * 10 + 9) {
                        if (ri.length() == 2 && !charMap.containsKey(ri.charAt(0))) {
                            charMap.put(ri.charAt(0), uniqueCount + 1);
                            uniqueCount++;
                        }
                    }
                }
            }

            while (uniqueCount < 10) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (!parts[0].equals("-1")) {
                    String ri = parts[1];
                    if (ri.length() == 2 && !charMap.containsKey(ri.charAt(1))) {
                        charMap.put(ri.charAt(1), 0);
                        uniqueCount++;
                    }
                }
            }

            for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
                char currentChar = entry.getKey();
                int index = entry.getValue();
                result.setCharAt(index, currentChar);
            }
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }
}