import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Read number of test cases

        for (int i = 0; i < t; i++) {
            int size = sc.nextInt(); // Read size of the matrix
            int trace = sc.nextInt(); // Read desired trace

            if (trace % size == 0 && trace / size <= size) {
                System.out.println("Case #" + (i + 1) + ": POSSIBLE");
                int p = trace / size;

                for (int row = 1; row <= size; row++) {
                    for (int col = 1; col <= size; col++) {
                        System.out.print((col + p - 2 + row - 1) % size + 1 + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
        sc.close();
    }
}