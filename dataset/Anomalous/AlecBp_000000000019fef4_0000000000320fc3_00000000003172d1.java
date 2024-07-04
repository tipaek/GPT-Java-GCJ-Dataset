import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            long[] slices = new long[n];
            
            for (int i = 0; i < n; i++) {
                slices[i] = scanner.nextLong();
            }
            
            Arrays.sort(slices);
            
            long currentSlice = slices[0];
            long bestSlice = slices[0];
            int maxCount = 1;
            int currentCount = 1;
            
            for (int i = 1; i < n; i++) {
                if (slices[i] == currentSlice) {
                    currentCount++;
                } else {
                    if (currentCount > maxCount) {
                        bestSlice = slices[i - 1];
                        maxCount = currentCount;
                    }
                    currentSlice = slices[i];
                    currentCount = 1;
                }
            }

            if (maxCount == d) {
                System.out.println("Case #" + testCase + ": " + 0);
            } else {
                if (d == 2) {
                    if (n == 1) {
                        System.out.println("Case #" + testCase + ": " + 1);
                    } 
                } else {
                    if (n == 1) {
                        System.out.println("Case #" + testCase + ": " + 2);
                    } else if (n == 2) {
                        System.out.println("Case #" + testCase + ": " + 1);
                    } else {
                        if (maxCount == 2) {
                            System.out.println("Case #" + testCase + ": " + 1);
                        } else {
                            System.out.println("Case #" + testCase + ": " + 1);
                        }
                    }
                }
            }
        }
    }
}