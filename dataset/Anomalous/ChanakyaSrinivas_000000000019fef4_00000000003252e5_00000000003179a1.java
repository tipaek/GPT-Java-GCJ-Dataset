import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int U = scanner.nextInt();
            Map<Character, Integer> digitMapping = new HashMap<>();
            Set<Character> allDigits = new HashSet<>();
            
            for (int i = 0; i < 10000; i++) {
                long M = scanner.nextLong();
                String R = scanner.next();
                
                int digitCount = String.valueOf(M).length();
                
                if (M != -1 && digitCount == R.length()) {
                    char firstChar = R.charAt(0);
                    int leadingDigit = (int) (M / Math.pow(10, digitCount - 1));
                    
                    digitMapping.putIfAbsent(firstChar, leadingDigit);
                    digitMapping.computeIfPresent(firstChar, (key, value) -> Math.min(value, leadingDigit));
                    
                    for (char ch : R.toCharArray()) {
                        allDigits.add(ch);
                    }
                }
            }
            
            char[] result = new char[10];
            Arrays.fill(result, ' ');
            
            for (Map.Entry<Character, Integer> entry : digitMapping.entrySet()) {
                result[entry.getValue()] = entry.getKey();
            }
            
            for (char ch : allDigits) {
                if (!digitMapping.containsKey(ch)) {
                    for (int i = 0; i < result.length; i++) {
                        if (result[i] == ' ') {
                            result[i] = ch;
                            break;
                        }
                    }
                }
            }
            
            System.out.print("Case #" + t + ": ");
            for (char ch : result) {
                if (ch != ' ') {
                    System.out.print(ch);
                }
            }
            System.out.println();
        }
        
        scanner.close();
    }
}