import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            System.out.println("Case #" + i + ":");
            int row = 1;
            int position = 1;
            int sum = 1;

            System.out.println(row + " " + position);

            while (sum < n) {
                if (sum + row - 1 < n) {
                    row++;
                    position = 2;
                    sum += row - 1;
                } else {
                    if (position == 1) {
                        row++;
                    }
                    position = 1;
                    sum++;
                }
                System.out.println(row + " " + position);
            }
        }
        scanner.close();
    }
}