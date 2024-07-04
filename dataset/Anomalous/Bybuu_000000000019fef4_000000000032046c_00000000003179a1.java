import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int recursive = scanner.nextInt();
        
        for (int r = 0; r < recursive; r++) {
            int U = scanner.nextInt();
            HashMap<Character, Integer> charMap = new HashMap<>();
            int flagged = 0;
            StringBuilder sb = new StringBuilder("          ");
            
            while (flagged < 2) {
                System.out.println(10);
                String line = scanner.next();
                String ri = line.split(" ")[1];
                
                if (ri.length() == 2) {
                    charMap.put(ri.charAt(1), 1);
                    charMap.put(ri.charAt(0), 0);
                    flagged = 2;
                }
            }
            
            while (flagged < 10) {
                System.out.print((flagged + 9));
                String line = scanner.next();
                String ri = line.split(" ")[1];
                
                if (ri.length() == 2 && !charMap.containsKey(ri.charAt(1))) {
                    charMap.put(ri.charAt(1), flagged);
                    flagged++;
                }
            }
            
            for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
                char currentChar = entry.getKey();
                int index = entry.getValue();
                sb.setCharAt(index, currentChar);
            }
            
            System.out.println(sb);
        }
    }
}