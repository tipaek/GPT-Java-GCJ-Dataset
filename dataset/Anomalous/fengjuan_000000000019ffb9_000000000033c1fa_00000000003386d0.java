import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int size = scanner.nextInt();
            long[] X = new long[size];
            long[] Y = new long[size];
            long maxPoints = 1;
            
            for (int i = 0; i < size; i++) {
                X[i] = scanner.nextLong();
                Y[i] = scanner.nextLong();
            }
            
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    int[] index = new int[size];
                    int[] count = new int[size];
                    int n = 0;
                    int m = 0;
                    
                    for (int k = 0; k < size; k++) {
                        if (index[k] != 0) continue;
                        
                        for (int l = k; l < size; l++) {
                            if ((X[k] - X[l]) * (Y[i] - Y[j]) != (X[i] - X[j]) * (Y[k] - Y[l])) {
                                continue;
                            }
                            index[l] = k + 1;
                        }
                    }
                    
                    for (int k = 0; k < size; k++) {
                        count[index[k] - 1]++;
                    }
                    
                    for (int k = 0; k < size; k++) {
                        if (count[k] == 1) {
                            m++;
                        } else {
                            n += count[k];
                        }
                    }
                    
                    long currentPoints = n + Math.min(m, 2 - n % 2);
                    if (currentPoints > maxPoints) {
                        maxPoints = currentPoints;
                    }
                }
            }
            System.out.println("Case #" + testCase + ": " + maxPoints);
        }
    }
}