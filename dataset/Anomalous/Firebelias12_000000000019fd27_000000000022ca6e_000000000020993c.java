import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            int n = scanner.nextInt();
            int[][] square = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    square[j][k] = scanner.nextInt();
                }
            }

            int trace = 0;
            int repeatR = 0;
            int repeatC = 0;

            for (int z = 0; z < n; z++) {
                trace += square[z][z];
            }

            for (int z = 0; z < n; z++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int l = 0; l < n; l++) {
                    if (!rowSet.add(square[z][l])) {
                        repeatR++;
                        break;
                    }
                }
            }

            for (int z = 0; z < n; z++) {
                Set<Integer> colSet = new HashSet<>();
                for (int l = 0; l < n; l++) {
                    if (!colSet.add(square[l][z])) {
                        repeatC++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + repeatR + " " + repeatC);
        }

        scanner.close();
    }
}