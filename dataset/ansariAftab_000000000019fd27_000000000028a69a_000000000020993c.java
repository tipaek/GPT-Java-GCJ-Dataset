
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        for (int t = 1; t<= test; t++) {
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i< n; i++) {
                for (int j = 0; j<n; j++) {
                    arr[i][j] = in.nextInt();
                }
            }
            int sum = 0;
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            int rowDuplicateCount = 0;
            int colDuplicateCount = 0;
            boolean isDupRowElt = false;
            boolean isDupColElt = false;
            for (int i = 0; i< n; i++) {
                for (int j = 0; j<n; j++) {
                    if (rowSet.contains(arr[i][j])) {
                        isDupRowElt = true;
                    }
                    if (colSet.contains(arr[j][i])) {
                        isDupColElt = true;
                    }
                    rowSet.add(arr[i][j]);
                    colSet.add(arr[j][i]);
                    if (i == j) {
                        sum += arr[i][j];
                    }
                }
                if (isDupRowElt) {
                    rowDuplicateCount += 1;
                }
                if (isDupColElt) {
                    colDuplicateCount += 1;
                }
//                System.out.println("r: -> " + rowSet + "\n c: -> : " + colSet + " " + colDuplicateCount);
                rowSet.clear();
                colSet.clear();
                isDupRowElt = false;
                isDupColElt = false;
            }

            System.out.println("Case #" + t + ": " + sum + " " + rowDuplicateCount + " " + colDuplicateCount);


        }
    }


}
