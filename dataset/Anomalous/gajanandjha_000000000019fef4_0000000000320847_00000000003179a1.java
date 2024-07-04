import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());
        
        for (int t = 1; t <= testCases; t++) {
            br.readLine(); // Read and ignore the blank line
            List<String> entries = new ArrayList<>();
            Set<Character> uniqueCharacters = new HashSet<>();
            
            for (int i = 0; i < 10000; i++) {
                String[] input = br.readLine().split("\\s+");
                if (input[0].length() == 1) {
                    entries.add(input[0] + "," + input[1]);
                }
                for (char ch : input[1].toCharArray()) {
                    uniqueCharacters.add(ch);
                }
            }
            
            StringBuilder result = new StringBuilder(" ");
            
            for (int i = 1; i < 10; i++) {
                for (String entry : entries) {
                    String[] parts = entry.split(",");
                    if (parts[0].equals(String.valueOf(i)) && !result.toString().contains(parts[1])) {
                        result.append(parts[1]);
                    }
                }
            }
            
            for (char ch : uniqueCharacters) {
                if (!result.toString().contains(String.valueOf(ch))) {
                    result.replace(0, 1, String.valueOf(ch));
                    break;
                }
            }
            
            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}