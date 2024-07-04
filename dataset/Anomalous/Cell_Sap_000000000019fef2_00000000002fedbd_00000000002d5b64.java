import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            int moves = (rows * columns) / 2 - 1;

            System.out.println("Case #" + testCase + ": " + moves);

            if (rows == 2 && columns == 2) {
                System.out.println("2 1");
            } else {
                for (int move = 1; move <= moves; move++) {
                    System.out.println(rows + " " + columns);
                    if (rows != 2) {
                        rows--;
                    }
                    columns--;
                }
            }
        }
    }
}