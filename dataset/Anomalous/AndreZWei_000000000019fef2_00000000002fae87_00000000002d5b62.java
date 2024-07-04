import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println("Case #" + i + ": " + findPath(x, y));
        }
    }

    public static String findPath(int x, int y) {
        boolean isXPositive = x >= 0;
        boolean isYPositive = y >= 0;
        
        x = Math.abs(x);
        y = Math.abs(y);
        
        int maxLength = Math.max(Integer.toBinaryString(x).length(), Integer.toBinaryString(y).length());
        boolean adjustmentNeeded = true;
        int adjustedX = 0, adjustedY = 0;
        
        for (int i = 0; i < maxLength; i++) {
            int bitX = (x >> i) & 1;
            int bitY = (y >> i) & 1;
            
            if (bitX == bitY) {
                if (i == 0) return "IMPOSSIBLE";
                
                if (((x >> (i - 1)) & 1) == 1) {
                    adjustedX += (1 << (i - 1));
                    x += (1 << (i - 1));
                }
                
                if (((y >> (i - 1)) & 1) == 1) {
                    adjustedY += (1 << (i - 1));
                    y += (1 << (i - 1));
                }
            }
            
            maxLength = Math.max(Integer.toBinaryString(x).length(), Integer.toBinaryString(y).length());
        }
        
        StringBuilder path = new StringBuilder();
        
        if (!isXPositive) {
            int temp = x;
            x = adjustedX;
            adjustedX = temp;
        }
        
        if (!isYPositive) {
            int temp = y;
            y = adjustedY;
            adjustedY = temp;
        }
        
        for (int i = 0; i < maxLength; i++) {
            if (((x >> i) & 1) == 1) {
                path.append('E');
            } else if (((adjustedX >> i) & 1) == 1) {
                path.append('W');
            } else if (((y >> i) & 1) == 1) {
                path.append('N');
            } else if (((adjustedY >> i) & 1) == 1) {
                path.append('S');
            }
        }
        
        return path.toString();
    }
}