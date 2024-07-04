import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            int valuesForNext = in.nextInt();
            int[][] intervals = new int[valuesForNext][2];
            char[] results = new char[valuesForNext];
            Arrays.fill(results, 'C');
            
            in.nextLine(); // Consume the newline after nextInt()
            for (int value = 0; value < valuesForNext; value++) {
                String line = in.nextLine();
                if (line.isEmpty()) {
                    value--;
                    continue;
                }
                String[] parts = line.split(" ");
                intervals[value][0] = Integer.parseInt(parts[0]);
                intervals[value][1] = Integer.parseInt(parts[1]);
            }
            
            boolean isImpossible = false;
            int[] overlapCount = new int[valuesForNext];
            int[][] overlaps = new int[valuesForNext][2];
            
            outerLoop:
            for (int index = 0; index < valuesForNext; index++) {
                for (int innerIndex = index + 1; innerIndex < valuesForNext; innerIndex++) {
                    if (isOverlapping(intervals[index], intervals[innerIndex])) {
                        overlapCount[index]++;
                        if (overlapCount[index] >= 3) {
                            System.out.println("Case #" + i + ": IMPOSSIBLE");
                            isImpossible = true;
                            break outerLoop;
                        }
                        overlaps[index][overlapCount[index] - 1] = innerIndex;
                        if (overlapCount[index] == 2) {
                            if (isOverlapping(intervals[overlaps[index][0]], intervals[overlaps[index][1]])) {
                                System.out.println("Case #" + i + ": IMPOSSIBLE");
                                isImpossible = true;
                                break outerLoop;
                            } else {
                                results[overlaps[index][0]] = 'J';
                                results[overlaps[index][1]] = 'J';
                            }
                        }
                    }
                }
            }
            
            if (!isImpossible) {
                for (int index = 0; index < valuesForNext; index++) {
                    if (results[index] == 'J') continue;
                    
                    for (int innerIndex = index + 1; innerIndex < valuesForNext; innerIndex++) {
                        if (results[innerIndex] == 'J') continue;
                        if (isOverlapping(intervals[index], intervals[innerIndex])) {
                            results[index] = 'J';
                            break;
                        }
                    }
                }
                
                System.out.print("Case #" + i + ": ");
                for (char result : results) {
                    System.out.print(result);
                }
                System.out.println();
            }
        }
    }
    
    private static boolean isOverlapping(int[] interval1, int[] interval2) {
        return interval1[0] < interval2[1] && interval2[0] < interval1[1];
    }
}