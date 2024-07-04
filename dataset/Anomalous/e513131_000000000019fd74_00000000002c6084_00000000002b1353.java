import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ":");

            int N = scanner.nextInt();
            System.out.println("1 1");
            System.out.println("1 1");
            System.out.println("2 2");

            N -= 4;

            for (int j = 0; j < N; j++) {
                System.out.println((3 + j) + " 0");
            }
        }

        scanner.close();
    }
}