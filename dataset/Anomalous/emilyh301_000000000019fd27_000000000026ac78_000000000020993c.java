import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());

        for (int x = 1; x <= num; x++) {
            int d = Integer.parseInt(sc.nextLine());
            String[][] square = new String[d][d];
            int sum = 0, row = 0, col = 0;

            for (int r = 0; r < d; r++) {
                square[r] = sc.nextLine().split(" ");
            }

            for (int r = 0; r < d; r++) {
                Set<String> rowSet = new HashSet<>();
                Set<String> colSet = new HashSet<>();

                for (int c = 0; c < d; c++) {
                    // Check for duplicate in row
                    if (!rowSet.add(square[r][c])) {
                        row++;
                        break;
                    }
                }

                for (int c = 0; c < d; c++) {
                    // Check for duplicate in column
                    if (!colSet.add(square[c][r])) {
                        col++;
                        break;
                    }
                }

                // Sum the diagonal
                sum += Integer.parseInt(square[r][r]);
            }

            // Sum the last element of the diagonal if d > 1
            if (d > 1) {
                sum += Integer.parseInt(square[d - 1][d - 1]);
            }

            System.out.println("Case #" + x + ": " + sum + " " + row + " " + col);
        }

        sc.close();
    }
}