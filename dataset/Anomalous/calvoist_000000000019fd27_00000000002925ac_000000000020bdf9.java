import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }
            
            List<Integer> cameron = new ArrayList<>();
            List<Integer> james = new ArrayList<>();
            StringBuilder answer = new StringBuilder();
            
            int start = intervals[0][0];
            int end = intervals[0][1];
            
            for (int k = start; k < end; k++) {
                cameron.add(k);
            }
            
            answer.append("C");
            
            for (int j = 1; j < n; j++) {
                start = intervals[j][0];
                end = intervals[j][1];
                boolean overlap = false;
                
                for (int k = start; k < end; k++) {
                    if (cameron.contains(k)) {
                        overlap = true;
                        break;
                    }
                }
                
                if (!overlap) {
                    for (int k = start; k < end; k++) {
                        cameron.add(k);
                    }
                    answer.append("C");
                } else {
                    overlap = false;
                    for (int k = start; k < end; k++) {
                        if (james.contains(k)) {
                            overlap = true;
                            break;
                        }
                    }
                    
                    if (!overlap) {
                        for (int k = start; k < end; k++) {
                            james.add(k);
                        }
                        answer.append("J");
                    } else {
                        answer = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + i + ": " + answer);
        }
        
        scanner.close();
    }
}