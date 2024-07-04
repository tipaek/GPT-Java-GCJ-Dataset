import java.util.*;

public class Solution {
    
    static Scanner scanner = new Scanner(System.in);
    
    static String processBits(int B) {
        int[] bits = new int[B + 1];
        int matchIndex = -1;
        int diffIndex = -1;
        int queryCount = 0;
        int temp;
        
        for (int i = 1; i <= B / 2; ++i) {
            if (queryCount > 0 && queryCount % 10 == 0) {
                if (matchIndex > -1) {
                    System.out.printf("%d\n", matchIndex);
                    temp = scanner.nextInt();
                    ++queryCount;
                    
                    if (bits[matchIndex] != temp) {
                        for (int j = 1; j < i; ++j) {
                            bits[j] ^= 1;
                            bits[B - j + 1] ^= 1;
                        }
                    }
                }
                
                if (diffIndex > -1) {
                    System.out.printf("%d\n", diffIndex);
                    temp = scanner.nextInt();
                    ++queryCount;
                    
                    if (bits[diffIndex] != temp) {
                        for (int j = 1; j < i; ++j) {
                            temp = bits[j];
                            bits[j] = bits[B - j + 1];
                            bits[B - j + 1] = temp;
                        }
                    }
                }
                
                if (queryCount % 2 == 1) {
                    System.out.printf("%d\n", 1);
                    temp = scanner.nextInt();
                }
            }
            
            System.out.printf("%d\n", i);
            bits[i] = scanner.nextInt();
            
            System.out.printf("%d\n", B - i + 1);
            bits[B - i + 1] = scanner.nextInt();
            
            if (matchIndex < 0 && bits[i] == bits[B - i + 1]) {
                matchIndex = i;
            } else if (diffIndex < 0 && bits[i] != bits[B - i + 1]) {
                diffIndex = i;
            }
            
            queryCount += 2;
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= B; ++i) {
            result.append(bits[i]);
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        int T = scanner.nextInt();
        int B = scanner.nextInt();
        
        for (int i = 1; i <= T; ++i) {
            String result = processBits(B);
            System.out.printf("%s\n", result);
            String response = scanner.next();
            if (response.equals("N")) {
                System.exit(0);
            }
        }
        
        scanner.close();
    }
}