import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            
            List<Integer> cIndices = new ArrayList<>();
            List<Integer> jIndices = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                if (!jIndices.contains(i)) {
                    cIndices.add(i);
                    for (int k = i + 1; k < n; k++) {
                        if (!jIndices.contains(k)) {
                            if (!(intervals[i][0] >= intervals[k][1] || intervals[i][1] <= intervals[k][0])) {
                                jIndices.add(k);
                            }
                        }
                    }
                }
            }
            
            boolean isImpossible = false;
            for (int i = 0; i < jIndices.size() - 1 && !isImpossible; i++) {
                for (int k = i + 1; k < jIndices.size(); k++) {
                    if (!(intervals[jIndices.get(i)][0] >= intervals[jIndices.get(k)][1] || intervals[jIndices.get(i)][1] <= intervals[jIndices.get(k)][0])) {
                        isImpossible = true;
                        break;
                    }
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                result.append("Case #").append(testCase).append(": ");
                for (int i = 0; i < n; i++) {
                    result.append(cIndices.contains(i) ? "C" : "J");
                }
                System.out.println(result.toString());
            }
        }
    }
}