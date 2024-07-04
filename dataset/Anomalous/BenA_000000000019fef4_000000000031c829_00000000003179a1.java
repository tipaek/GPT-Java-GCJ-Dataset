import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            HashMap<Character, Integer> frequencyMap = new HashMap<>();
            scanner.nextLine(); // Skip the empty line
            
            for (int i = 0; i < 10000; i++) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                String stem = parts[1];
                char firstChar = stem.charAt(0);
                
                if (i > 5000 && stem.length() > 1) {
                    char secondChar = stem.charAt(1);
                    frequencyMap.putIfAbsent(secondChar, 10000);
                }
                
                frequencyMap.put(firstChar, frequencyMap.getOrDefault(firstChar, 0) + 1);
            }
            
            List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
            sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
            
            StringBuilder result = new StringBuilder();
            for (Map.Entry<Character, Integer> entry : sortedEntries) {
                result.append(entry.getKey());
            }
            
            System.out.println("Case #" + caseNum + ": " + result.toString());
        }
    }
}