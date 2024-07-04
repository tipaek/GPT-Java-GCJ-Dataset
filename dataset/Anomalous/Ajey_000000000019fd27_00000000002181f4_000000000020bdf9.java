import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] sortedEndTimes = new int[n];
            int[] indices = new int[n];
            
            for (int i = 0; i < n; i++) {
                indices[i] = i;
            }
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            
            Map<Integer, Integer> indexMap = new HashMap<>(n);
            for (int i = 0; i < n; i++) {
                indexMap.put(startTimes[i], indices[i]);
            }
            
            Arrays.sort(startTimes);
            for (int i = 0; i < n; i++) {
                indices[i] = indexMap.get(startTimes[i]);
            }
            
            for (int i = 0; i < n; i++) {
                sortedEndTimes[i] = endTimes[indices[i]];
            }
            
            boolean isPossible = true;
            int cEnd = sortedEndTimes[0], jEnd = 0;
            StringBuilder result = new StringBuilder("C");
            
            for (int i = 1; i < n; i++) {
                if (startTimes[i] >= cEnd) {
                    cEnd = sortedEndTimes[i];
                    result.append("C");
                } else if (startTimes[i] >= jEnd) {
                    jEnd = sortedEndTimes[i];
                    result.append("J");
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
                System.out.print("Case #" + t + ": ");
                char[] assignment = result.toString().toCharArray();
                char[] finalAssignment = new char[n];
                for (int i = 0; i < n; i++) {
                    finalAssignment[i] = assignment[indices[i]];
                }
                for (char ch : finalAssignment) {
                    System.out.print(ch);
                }
                System.out.println();
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}