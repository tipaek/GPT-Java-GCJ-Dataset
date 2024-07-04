import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.print("Case #" + i + ": ");
            solve(scanner);
        }
    }

    public static void solve(Scanner scanner) {
        int N = scanner.nextInt();
        int D = scanner.nextInt();
        long[] values = new long[N];
        Set<Long> possibleSizes = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            values[i] = scanner.nextLong() * D;
            possibleSizes.add(values[i]);
            possibleSizes.add(values[i] / D);
        }
        
        Arrays.sort(values);
        long minimumCuts = D - 1;
        
        for (long size : possibleSizes) {
            long slices = 0;
            long cuts = 0;
            List<Long> goodValues = new ArrayList<>();
            List<Long> badValues = new ArrayList<>();
            
            for (long value : values) {
                if (value >= size && value % size == 0) {
                    goodValues.add(value);
                } else {
                    badValues.add(value);
                }
            }
            
            boolean isPossible = false;
            
            for (long goodValue : goodValues) {
                slices += goodValue / size;
                cuts += goodValue / size;
                if (slices >= D) {
                    cuts -= (slices - D);
                    isPossible = true;
                    break;
                }
                cuts--;
            }
            
            for (long badValue : badValues) {
                slices += badValue / size;
                cuts += badValue / size;
                if (slices >= D) {
                    cuts -= (slices - D);
                    isPossible = true;
                    break;
                }
            }
            
            if (isPossible) {
                minimumCuts = Math.min(minimumCuts, cuts);
            }
        }
        
        System.out.println(minimumCuts);
    }
}