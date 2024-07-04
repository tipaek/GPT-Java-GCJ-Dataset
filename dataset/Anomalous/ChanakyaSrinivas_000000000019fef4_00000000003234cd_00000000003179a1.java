import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int U = scanner.nextInt();
            HashMap<Character, Integer> digitMap = new HashMap<>();
            HashSet<Character> allDigits = new HashSet<>();
            
            for (int i = 0; i < 10000; i++) {
                long M = scanner.nextLong();
                String R = scanner.next();
                
                int digitCount = 1;
                long tempM = M;
                while (tempM > 9) {
                    digitCount++;
                    tempM /= 10;
                }
                
                if (tempM != -1 && digitCount == R.length()) {
                    char firstChar = R.charAt(0);
                    if (!digitMap.containsKey(firstChar) || digitMap.get(firstChar) > tempM) {
                        digitMap.put(firstChar, (int) tempM);
                    }
                    
                    for (char ch : R.toCharArray()) {
                        allDigits.add(ch);
                    }
                }
            }
            
            char[] result = new char[10];
            for (Map.Entry<Character, Integer> entry : digitMap.entrySet()) {
                result[entry.getValue()] = entry.getKey();
            }
            
            for (char ch : allDigits) {
                if (!digitMap.containsKey(ch)) {
                    result[0] = ch;
                }
            }
            
            System.out.print("Case #" + t + ": ");
            for (char ch : result) {
                System.out.print(ch);
            }
            System.out.println();
        }
        
        scanner.close();
    }
}