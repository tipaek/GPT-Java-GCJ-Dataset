import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String[] input = scanner.nextLine().trim().split(" ");
            int rows = Integer.parseInt(input[0]);
            int cols = Integer.parseInt(input[1]);

            System.out.println("Case #" + caseNumber + ": " + (cols - 1) * (rows - 1));

            int counter = 0;
            for (int row = rows - 1; row > 0; row--) {
                for (int col = cols - 1; col > 0; col--) {
                    System.out.println(rows * (cols - 1) - counter + " " + row);
                    counter++;
                }
            }
        }

        scanner.close();
    }
}