import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());

        for (int x = 1; x <= num; x++) {
            int sum = 0, row = 0, col = 0;
            int d = Integer.parseInt(sc.nextLine());
            String[][] square = new String[d][d];

            for (int r = 0; r < d; r++) {
                square[r] = sc.nextLine().split(" ");
            }

            for (int r = 0; r < d; r++) {
                Set<String> rowSet = new HashSet<>();
                Set<String> colSet = new HashSet<>();
                boolean rowDuplicate = false;
                boolean colDuplicate = false;

                for (int c = 0; c < d; c++) {
                    if (!rowSet.add(square[r][c])) {
                        rowDuplicate = true;
                    }
                    if (!colSet.add(square[c][r])) {
                        colDuplicate = true;
                    }
                    if (r == c) {
                        sum += Integer.parseInt(square[r][c]);
                    }
                }

                if (rowDuplicate) {
                    row++;
                }
                if (colDuplicate) {
                    col++;
                }
            }

            System.out.println("Case #" + x + ": " + sum + " " + row + " " + col);
        }

        sc.close();
    }
}