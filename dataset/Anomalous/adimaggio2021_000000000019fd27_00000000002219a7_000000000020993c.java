import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int run = in.nextInt();
        
        for (int m = 0; m < run; m++) {
            int n = in.nextInt();
            int[][] sq = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sq[i][j] = in.nextInt();
                }
            }
            
            int trace = calculateTrace(sq, n);
            int colcount = calculateColumnDuplicates(sq, n);
            int rowcount = calculateRowDuplicates(sq, n);
            
            System.out.println("Case #" + (m + 1) + ": " + trace + " " + colcount + " " + rowcount);
        }
        
        in.close();
    }

    private static int calculateTrace(int[][] sq, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += sq[i][i];
        }
        return trace;
    }

    private static int calculateColumnDuplicates(int[][] sq, int n) {
        int colcount = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            boolean duplicateFound = false;
            for (int j = 0; j < n; j++) {
                if (!seen.add(sq[i][j])) {
                    duplicateFound = true;
                    break;
                }
            }
            if (duplicateFound) {
                colcount++;
            }
        }
        return colcount;
    }

    private static int calculateRowDuplicates(int[][] sq, int n) {
        int rowcount = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            boolean duplicateFound = false;
            for (int j = 0; j < n; j++) {
                if (!seen.add(sq[j][i])) {
                    duplicateFound = true;
                    break;
                }
            }
            if (duplicateFound) {
                rowcount++;
            }
        }
        return rowcount;
    }
}