import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        for (int t = 0; t < testCases; t++) {
            int U = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            
            Map<Character, Integer> charMap = new HashMap<>();
            int assignedCount = 0;
            StringBuilder result = new StringBuilder("          ");
            
            while (assignedCount < 2) {
                System.out.println(10);
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (!parts[0].equals("-1") && parts[1].length() == 2) {
                    charMap.put(parts[1].charAt(0), 1);
                    charMap.put(parts[1].charAt(1), 0);
                    assignedCount = 2;
                }
            }
            
            while (assignedCount < 10) {
                System.out.println((assignedCount * 10 + 9));
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (!parts[0].equals("-1")) {
                    String ri = parts[1];
                    if (ri.length() == 2 && !charMap.containsKey(ri.charAt(0))) {
                        charMap.put(ri.charAt(0), assignedCount);
                        assignedCount++;
                    }
                }
            }
            
            for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
                result.setCharAt(entry.getValue(), entry.getKey());
            }
            
            System.out.println(result);
        }
        
        scanner.close();
    }
}