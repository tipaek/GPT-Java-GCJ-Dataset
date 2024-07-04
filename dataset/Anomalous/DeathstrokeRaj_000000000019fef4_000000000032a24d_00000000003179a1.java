import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long testCases = scanner.nextLong();
        
        for (long testCase = 1; testCase <= testCases; testCase++) {
            HashMap<Character, Integer> characterValues = new HashMap<>();
            HashMap<Character, Integer> zeroValues = new HashMap<>();
            long U = scanner.nextLong();
            
            for (long i = 0; i < 10000; i++) {
                long Q = scanner.nextLong();
                if (Q == -1) {
                    Q = (long) (Math.pow(10, U) - 1);
                }
                
                String value = scanner.next();
                char firstChar = value.charAt(0);
                
                for (char ch : value.toCharArray()) {
                    characterValues.putIfAbsent(ch, 9);
                    zeroValues.putIfAbsent(ch, 0);
                }
                
                zeroValues.put(firstChar, -1);
                characterValues.put(firstChar, Math.min(characterValues.get(firstChar), (int) (Q / Math.pow(10, value.length() - 1))));
            }
            
            zeroValues.forEach((character, zeroValue) -> {
                if (zeroValue == 0) {
                    characterValues.put(character, zeroValue);
                }
            });
            
            char[] result = new char[10];
            characterValues.forEach((character, value) -> {
                result[value] = character;
            });
            
            System.out.println("Case #" + testCase + ": " + new String(result));
        }
        
        scanner.close();
    }
}