import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int T = 1; T <= t; T++) {
            Map<Character, Integer> serverValues = new HashMap<>();
            Map<Character, Integer> valueZero = new HashMap<>();
            int U = scanner.nextInt();
            
            for (int i = 0; i < 10000; i++) {
                int Q = scanner.nextInt();
                if (Q == -1) continue;
                
                String value = scanner.next();
                char alpha = value.charAt(0);
                
                for (char c : value.toCharArray()) {
                    serverValues.putIfAbsent(c, 9);
                    valueZero.putIfAbsent(c, 0);
                }
                
                valueZero.put(alpha, -1);
                int calculatedValue = (int) (Q / Math.pow(10, value.length() - 1));
                serverValues.put(alpha, Math.min(serverValues.get(alpha), calculatedValue));
            }
            
            for (Map.Entry<Character, Integer> entry : valueZero.entrySet()) {
                if (entry.getValue() == 0) {
                    serverValues.put(entry.getKey(), 0);
                }
            }
            
            char[] result = new char[10];
            for (Map.Entry<Character, Integer> entry : serverValues.entrySet()) {
                result[entry.getValue()] = entry.getKey();
            }
            
            System.out.println("Case #" + T + ": " + new String(result));
        }
        
        scanner.close();
    }
}