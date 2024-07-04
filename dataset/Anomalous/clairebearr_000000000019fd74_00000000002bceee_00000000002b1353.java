import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + testCase + ":");
            System.out.println("1 1");
            
            int currentSum = 1;
            if (n == 1) continue;
            
            System.out.println("2 1");
            currentSum = 2;
            int step = 2;
            
            while (currentSum + step <= n) {
                System.out.println((step + 1) + " " + 2);
                currentSum += step;
                step++;
            }
            
            while (currentSum < n) {
                System.out.println(step + " " + 1);
                currentSum++;
                step++;
            }
        }
    }
}