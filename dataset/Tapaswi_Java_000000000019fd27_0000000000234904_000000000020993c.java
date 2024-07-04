import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static void solution(Scanner scanner) {

        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int sum = 0;
            int duplicateRows = 0, duplicateCols = 0;
            int arr[][] = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = scanner.nextInt();
                }
            }

            for (int j = 0; j < n; j++) {
                Set rowSet = new HashSet();
                Set colSet = new HashSet();
                sum += arr[j][j];
                for (int k = 0; k < n; k++) {
                    rowSet.add(arr[j][k]);
                    colSet.add(arr[k][j]);
                }
                if (rowSet.size() != n) {
                    duplicateRows++;
                }
                if (colSet.size() != n) {
                    duplicateCols++;
                }
            }
            System.out.println("Case #"+i+": "+sum+" "+duplicateRows+" "+duplicateCols);
        }

        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        solution(scanner);
    }
}