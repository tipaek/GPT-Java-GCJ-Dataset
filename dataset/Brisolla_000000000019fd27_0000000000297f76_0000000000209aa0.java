import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Integer cases = in.nextInt();

        for (int i = 1; i <= cases; i++) {

            Integer n = in.nextInt();
            Integer k = in.nextInt();

            List<Integer> possibilities = new ArrayList<>();

            if (k % n != 0) {
                System.out.format("Case #%d: IMPOSSIBLE\n", i);


            } else {
                for (int j = 1; j <= n; j++) {
                    if ((n * j) == k) {
                        System.out.format("Case #%d: POSSIBLE\n", i);
                        createMatrixByIndex(n, j);
                        break;
                    }
                }
            }
        }
    }

    private static void createMatrixByIndex(int n, int mainNumber) {

        int[][] matrix = new int[n][n];

        int count = mainNumber;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                matrix[i][j] = count;
                System.out.print(count);

                if (j < n - 1) {
                    count++;
                    System.out.print(" ");
                }

                if (count > n)
                    count = 1;
            }
            System.out.println("");
        }
    }
}
