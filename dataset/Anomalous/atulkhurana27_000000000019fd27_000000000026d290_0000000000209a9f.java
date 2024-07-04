import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            String s = sc.next();
            StringBuilder result = new StringBuilder();
            
            Integer prev = null;
            int totalOpen = 0;
            int totalClose = 0;
            
            for (int j = 0; j < s.length(); j++) {
                int x = Character.getNumericValue(s.charAt(j));
                
                if (prev == null) {
                    totalOpen += x;
                    result.append(repeatChar('(', x)).append(x);
                } else {
                    if (prev > x) {
                        totalClose += prev - x;
                        result.append(repeatChar(')', prev - x)).append(x);
                    } else if (prev < x) {
                        totalOpen += x - prev;
                        result.append(repeatChar('(', x - prev)).append(x);
                    } else {
                        result.append(x);
                    }
                }
                prev = x;
            }
            
            result.append(repeatChar(')', totalOpen - totalClose));
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
    
    private static String repeatChar(char ch, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(ch);
        }
        return result.toString();
    }
}