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
            int identifiedChars = 0;
            StringBuilder result = new StringBuilder("          ");
            scanner.nextLine(); // Consume the remaining newline
            int queriesProcessed = 0;
            
            // First loop: Identify the first 9 unique characters
            while (identifiedChars < 9) {
                String line = scanner.nextLine();
                queriesProcessed++;
                String[] parts = line.split(" ");
                if (!parts[0].equals("-1")) {
                    String N = parts[0];
                    int ni = Integer.parseInt(N);
                    String ri = parts[1];
                    if (ni <= (identifiedChars + 1) * 10 + 9 && ri.length() == 2 && !charMap.containsKey(ri.charAt(0))) {
                        charMap.put(ri.charAt(0), identifiedChars + 1);
                        identifiedChars++;
                    }
                }
            }
            
            // Second loop: Identify the 10th unique character
            while (identifiedChars < 10) {
                queriesProcessed++;
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (!parts[0].equals("-1")) {
                    String ri = parts[1];
                    if (ri.length() == 2 && !charMap.containsKey(ri.charAt(1))) {
                        charMap.put(ri.charAt(1), 0);
                        identifiedChars++;
                    }
                }
            }
            
            // Consume remaining lines up to 10000 queries
            while (queriesProcessed < 10000) {
                queriesProcessed++;
                scanner.nextLine();
            }
            
            // Build the result string based on identified characters
            for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
                char currentChar = entry.getKey();
                int index = entry.getValue();
                result.setCharAt(index, currentChar);
            }
            
            // Print the result for the current test case
            System.out.print("Case #" + (t + 1) + ": " + result);
        }
        
        scanner.close();
    }
}