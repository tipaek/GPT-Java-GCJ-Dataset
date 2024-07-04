import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = input.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            int x = input.nextInt();
            int y = input.nextInt();
            
            int maxDistance = Math.abs(x) + Math.abs(y);
            int maxExp = 0;
            int totalUnits = 1;
            
            while (totalUnits < maxDistance) {
                maxExp++;
                totalUnits += (1 << maxExp);
            }
            
            StringBuilder result = new StringBuilder();
            if (findPath(maxExp + 1, x, y, result)) {
                System.out.println("Case #" + i + ": " + result.reverse().toString());
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }
    
    private static boolean findPath(int exp, int x, int y, StringBuilder result) {
        if (exp == 0) {
            return x == 0 && y == 0;
        }
        
        int step = 1 << (exp - 1);
        
        if (x > 0) {
            result.append("E");
            if (findPath(exp - 1, x - step, y, result)) {
                return true;
            }
            result.deleteCharAt(result.length() - 1);
        } else if (x < 0) {
            result.append("W");
            if (findPath(exp - 1, x + step, y, result)) {
                return true;
            }
            result.deleteCharAt(result.length() - 1);
        }
        
        if (y > 0) {
            result.append("N");
            if (findPath(exp - 1, x, y - step, result)) {
                return true;
            }
            result.deleteCharAt(result.length() - 1);
        } else if (y < 0) {
            result.append("S");
            if (findPath(exp - 1, x, y + step, result)) {
                return true;
            }
            result.deleteCharAt(result.length() - 1);
        }
        
        return false;
    }
}