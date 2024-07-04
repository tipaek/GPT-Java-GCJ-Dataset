import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int h = scanner.nextInt();
            int v = scanner.nextInt();
            
            int reversedH = reverseBits(Math.abs(h));
            int reversedV = reverseBits(Math.abs(v));
            int sum = Math.abs(h) + 2 * reversedH + 2 * reversedV + Math.abs(v);
            int k = (int) (Math.log(sum + 1) / Math.log(2));
            
            if (Math.pow(2, k) == sum + 1) {
                System.out.println("Case #" + t + ": " + generatePath(h, v, reversedH, reversedV, k));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    static int reverseBits(int n) {
        int result = 0;
        int k = (int) (Math.log(n) / Math.log(2));
        
        for (int i = 0; i < k; i++) {
            if ((n & (1 << i)) == 0) {
                result |= 1 << i;
            }
        }
        
        return result;
    }

    static String generatePath(int h, int v, int reversedH, int reversedV, int k) {
        char[] path = new char[k];
        
        if (h > 0) {
            for (int i = 0; i < k; i++) {
                if (((h + reversedV) & (1 << i)) != 0) path[i] = 'E';
                if ((reversedV & (1 << i)) != 0) path[i] = 'W';
            }
        } else {
            for (int i = 0; i < k; i++) {
                if (((-h + reversedV) & (1 << i)) != 0) path[i] = 'W';
                if ((reversedV & (1 << i)) != 0) path[i] = 'E';
            }
        }
        
        if (v > 0) {
            for (int i = 0; i < k; i++) {
                if (((v + reversedH) & (1 << i)) != 0) path[i] = 'N';
                if ((reversedH & (1 << i)) != 0) path[i] = 'S';
            }
        } else {
            for (int i = 0; i < k; i++) {
                if (((-v + reversedH) & (1 << i)) != 0) path[i] = 'S';
                if ((reversedH & (1 << i)) != 0) path[i] = 'N';
            }
        }
        
        return new String(path);
    }
}