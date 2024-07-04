import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        // Input:
        //  first line - num test cases
        //  each test case
        //      first line - size of square matrix
        //      n lines follow containing matrix

        // Output:
        //      Case#x: k r c, where x is the test case number (starting at 1), k is trace of matrix (sum of diagonal elements from top left to bottom right)
        //          r is number of rows that contain repeated elements, c is number of columns that contain repeated elements

        // N is bounded by 100
        // Each element is between 1 and N including both
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();

        for (int x = 1; x <= numTestCases; x++) {
            // Create matrix
            int N = scanner.nextInt();
            int k = 0; // trace
            int r = 0;
            int c = 0;
            ArrayList<HashSet<Integer>> rowDup = new ArrayList<>();
            ArrayList<HashSet<Integer>> colDup = new ArrayList<>();
            // Initialize hashsets
            for (int i = 0; i < N; i++) {
                rowDup.add(new HashSet<>());
                colDup.add(new HashSet<>());
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int num = scanner.nextInt();
                    if (i == j) {
                        k += num;
                    }
                    rowDup.get(i).add(num);
                    colDup.get(j).add(num);
                }
            }

            for (int i = 0; i < N; i++) {
                if (rowDup.get(i).size() != N) {
                    r++;
                }
                if (colDup.get(i).size() != N) {
                    c++;
                }
            }

            System.out.println("Case #"+x+": " + k + " "+ r + " " + c);
        }
    }
}
