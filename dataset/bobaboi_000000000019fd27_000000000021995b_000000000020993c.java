import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    static int caseCount = 1;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        for (int i = 0; i < count; i++) {
            solve(scan);
        }
    }
    public static void solve(Scanner scan) {
        int size = scan.nextInt();
        int arr[][] = new int[size][size];

        int k = 0;
        int r = 0;
        int c = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int curr = scan.nextInt();
                if (i == j) {
                    k += curr;
                }
                arr[i][j] = curr;
            }
        }

        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean rowDuplicate = false;
            for (int j = 0; j < size; j++) {
                if (rowSet.contains(arr[i][j])) {
                    rowDuplicate = true;
                }
                rowSet.add(arr[i][j]);
            }
            if (rowDuplicate) {
                r++;
            }
        }

        for (int j = 0; j < size; j++) {
            Set<Integer> colSet = new HashSet<>();
            boolean columnDuplicate = false;
            for (int i = 0; i < size; i++) {
                if (colSet.contains(arr[i][j])) {
                    columnDuplicate = true;
                }
                colSet.add(arr[i][j]);
            }
            if (columnDuplicate) {
                c++;
            }
        }
        System.out.println("Case #" + caseCount + ": " + k + " " + r + " " + c);
        caseCount++;
    }
}
