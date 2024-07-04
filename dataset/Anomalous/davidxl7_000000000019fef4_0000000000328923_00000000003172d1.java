import java.io.*;
import java.util.*;

public class OversizedPancake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        for (int i = 1; i <= testCaseCount; i++) {
            System.out.print("Case #" + i + ": ");
            solve(scanner);
        }
    }

    public static void solve(Scanner scanner) {
        int pancakeCount = scanner.nextInt();
        int desiredSlices = scanner.nextInt();
        long[] pancakeSizes = new long[pancakeCount];
        Set<Long> possibleSizes = new HashSet<>();
        
        for (int i = 0; i < pancakeCount; i++) {
            pancakeSizes[i] = scanner.nextLong();
            possibleSizes.add(pancakeSizes[i]);
            pancakeSizes[i] *= desiredSlices;
            possibleSizes.add(pancakeSizes[i]);
        }
        
        Arrays.sort(pancakeSizes);
        long minimumCuts = desiredSlices - 1;
        
        for (long size : possibleSizes) {
            long totalSlices = 0;
            long totalCuts = 0;
            List<Long> goodPancakes = new ArrayList<>();
            List<Long> badPancakes = new ArrayList<>();
            
            for (long pancake : pancakeSizes) {
                if (pancake >= size && pancake % size == 0) {
                    goodPancakes.add(pancake);
                } else {
                    badPancakes.add(pancake);
                }
            }
            
            boolean achievedDesiredSlices = false;
            for (long goodPancake : goodPancakes) {
                totalSlices += (goodPancake / size);
                totalCuts += (goodPancake / size);
                
                if (totalSlices == desiredSlices || totalSlices == desiredSlices + 1) {
                    totalCuts--;
                    achievedDesiredSlices = true;
                    break;
                } else if (totalSlices > desiredSlices) {
                    totalCuts -= (totalSlices - desiredSlices);
                    achievedDesiredSlices = true;
                    break;
                }
                totalCuts--;
            }
            
            if (!achievedDesiredSlices) {
                for (long badPancake : badPancakes) {
                    totalSlices += (badPancake / size);
                    totalCuts += (badPancake / size);
                    
                    if (totalSlices >= desiredSlices) {
                        totalCuts -= (totalSlices - desiredSlices);
                        achievedDesiredSlices = true;
                        break;
                    }
                }
            }
            
            if (achievedDesiredSlices) {
                minimumCuts = Math.min(minimumCuts, totalCuts);
            }
        }
        
        System.out.println(minimumCuts);
    }
}