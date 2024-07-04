import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int trace = scanner.nextInt();

            if (trace % size == 0 && trace / size <= size) {
                System.out.println("Case #" + testCase + ": POSSIBLE");
                int quotient = trace / size;
                int decrement = size + 1;

                for (int row = 1; row <= size; row++) {
                    int temp = decrement;

                    while (temp <= size) {
                        System.out.print((temp + quotient - 2) % size + 1 + " ");
                        temp++;
                    }

                    for (int col = 1; col < decrement; col++) {
                        System.out.print((col + quotient - 2) % size + 1 + " ");
                    }

                    decrement--;
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }
}