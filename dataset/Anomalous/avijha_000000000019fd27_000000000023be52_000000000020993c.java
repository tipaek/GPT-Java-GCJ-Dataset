import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= totalCases; testCase++) {
            int n = scanner.nextInt();
            boolean[][] columnTracker = new boolean[n + 1][n + 1];
            boolean[] columnCompleted = new boolean[n + 1];
            int rowRepeats = 0;
            int columnRepeats = 0;
            int traceSum = 0;
            
            for (int i = 0; i < n; i++) {
                boolean[] rowTracker = new boolean[n + 1];
                boolean rowDone = false;
                
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    
                    if (i == j) {
                        traceSum += value;
                    }
                    
                    if (!rowDone) {
                        if (rowTracker[value]) {
                            rowDone = true;
                            rowRepeats++;
                        } else {
                            rowTracker[value] = true;
                        }
                    }
                    
                    if (!columnCompleted[j]) {
                        if (columnTracker[j][value]) {
                            columnCompleted[j] = true;
                            columnRepeats++;
                        } else {
                            columnTracker[j][value] = true;
                        }
                    }
                }
            }
            
            System.out.println("Case #" + testCase + ": " + traceSum + " " + rowRepeats + " " + columnRepeats);
        }
        
        scanner.close();
    }
}