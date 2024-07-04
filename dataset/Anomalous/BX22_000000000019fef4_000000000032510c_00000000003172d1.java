import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int slices = scanner.nextInt();
            int diners = scanner.nextInt();
            long[] sizes = new long[slices];
            
            for (int j = 0; j < slices; j++) {
                sizes[j] = scanner.nextLong();
            }
            
            int result = findMinimumCuts(slices, diners, sizes);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static int findMinimumCuts(int slices, int diners, long[] sizes) {
        int minimumCuts = Integer.MAX_VALUE;
        
        for (int i = 0; i < slices; i++) {
            List<Long> divisibleSizes = new ArrayList<>();
            int remainingDiners = diners;
            
            for (int j = 0; j < slices; j++) {
                if (sizes[i] == sizes[j]) {
                    remainingDiners--;
                } else if (sizes[j] % sizes[i] == 0) {
                    divisibleSizes.add(sizes[j] / sizes[i]);
                }
            }
            
            Collections.sort(divisibleSizes);
            int cuts = 0;
            int index = 0;
            
            while (index < divisibleSizes.size() && remainingDiners - divisibleSizes.get(index) >= 0) {
                long div = divisibleSizes.get(index);
                cuts += div - 1;
                remainingDiners -= div;
                index++;
            }
            
            cuts += remainingDiners;
            minimumCuts = Math.min(minimumCuts, cuts);
        }
        
        return minimumCuts;
    }
}