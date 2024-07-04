import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());
        
        for (int t = 1; t <= testCases; t++) {
            br.readLine();
            Map<String, Integer> frequencyMap = new HashMap<>();
            
            for (int i = 0; i < 10000; i++) {
                String[] input = br.readLine().split("\\s+");
                char[] characters = input[1].toCharArray();
                
                for (char ch : characters) {
                    String key = String.valueOf(ch);
                    frequencyMap.put(key, frequencyMap.getOrDefault(key, 0) + 1);
                }
            }
            
            Map<String, Integer> sortedMap = sortByValue(frequencyMap);
            StringBuilder result = new StringBuilder();
            
            for (String key : sortedMap.keySet()) {
                result.append(key);
            }
            
            System.out.println("Case #" + t + ": " + result.charAt(result.length() - 1) + result.substring(0, result.length() - 1));
        }
    }
    
    public static Map<String, Integer> sortByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        
        list.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        
        return sortedMap;
    }
}