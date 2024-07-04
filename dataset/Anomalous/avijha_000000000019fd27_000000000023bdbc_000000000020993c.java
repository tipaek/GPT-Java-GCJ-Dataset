import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= totalCases; testCase++) {
            int n = scanner.nextInt();
            boolean[][] columnTracker = new boolean[n + 1][n + 1];
            boolean[] columnCompleted = new boolean[n + 1];
            int rowDuplicates = 0;
            int columnDuplicates = 0;
            int trace = 0;
            
            for (int i = 0; i < n; i++) {
                boolean[] rowTracker = new boolean[n + 1];
                boolean rowHasDuplicate = false;
                
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    
                    if (i == j) {
                        trace += value;
                    }
                    
                    if (!rowHasDuplicate) {
                        if (rowTracker[value]) {
                            rowHasDuplicate = true;
                            rowDuplicates++;
                        } else {
                            rowTracker[value] = true;
                        }
                    }
                    
                    if (!columnCompleted[j]) {
                        if (columnTracker[j][value]) {
                            columnCompleted[j] = true;
                            columnDuplicates++;
                        } else {
                            columnTracker[j][value] = true;
                        }
                    }
                }
            }
            
            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
        }
        
        scanner.close();
    }
}