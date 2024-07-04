import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseID = 1; caseID <= testCases; caseID++) {
            int N = scanner.nextInt();
            int trace = scanner.nextInt();
            
            // Check if the trace is less than N
            if (trace < N) {
                System.out.println("Case #" + caseID + ": IMPOSSIBLE");
                continue;
            }
            
            int[][] matrix = new int[N][N];
            List<Set<Integer>> rows = new ArrayList<>();
            List<Set<Integer>> columns = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                rows.add(new HashSet<>());
                columns.add(new HashSet<>());
                for (int j = 1; j <= N; j++) {
                    rows.get(i).add(j);
                    columns.get(i).add(j);
                }
            }
            
            // Initialize matrix with zeros
            for (int i = 0; i < N; i++) {
                Arrays.fill(matrix[i], 0);
            }
            
            int tempTrace = trace;
            int newTrace = 0;
            
            for (int i = 0; i < N; i++) {
                tempTrace = (int) ((tempTrace / 2.0) + 0.5);
                int newValue = tempTrace;
                matrix[i][i] = newValue;
                columns.get(i).remove(newValue);
                rows.get(i).remove(newValue);
                newTrace += newValue;
            }
            
            boolean isImpossible = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    
                    int selectedValue = 0;
                    while (!columns.get(j).contains(selectedValue) || !rows.get(i).contains(selectedValue)) {
                        selectedValue++;
                        if (selectedValue > N || columns.get(j).isEmpty() || rows.get(i).isEmpty()) {
                            isImpossible = true;
                            break;
                        }
                    }
                    
                    if (isImpossible) break;
                    
                    columns.get(j).remove(selectedValue);
                    rows.get(i).remove(selectedValue);
                    matrix[i][j] = selectedValue;
                }
                if (isImpossible) break;
            }
            
            if (isImpossible) {
                System.out.println("Case #" + caseID + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseID + ": POSSIBLE");
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}