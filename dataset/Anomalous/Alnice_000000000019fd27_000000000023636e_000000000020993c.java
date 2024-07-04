import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= numTestCases; testCase++) {
            int N = scanner.nextInt();
            int[] columnSums = new int[N];
            int[] rowSums = new int[N];
            int trace = 0;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int cellValue = scanner.nextInt();
                    if (i == j) {
                        trace += cellValue;
                    }
                    columnSums[i] ^= (cellValue ^ (j + 1));
                    rowSums[j] ^= (cellValue ^ (i + 1));
                }
            }
            
            int duplicateColumns = 0;
            int duplicateRows = 0;
            
            for (int i = 0; i < N; i++) {
                if (columnSums[i] != 0) {
                    duplicateColumns++;
                }
                if (rowSums[i] != 0) {
                    duplicateRows++;
                }
            }
            
            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, duplicateColumns, duplicateRows);
        }
        
        scanner.close();
    }
}