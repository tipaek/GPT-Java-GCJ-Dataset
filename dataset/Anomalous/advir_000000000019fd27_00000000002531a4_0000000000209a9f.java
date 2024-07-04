import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < t; i++) {
            String qItems = scanner.nextLine();
            System.out.print("Case #" + (i + 1) + ": ");
            int[] q = qItems.chars().map(Character::getNumericValue).toArray();

            int currentDepth = 0;
            for (int j = 0; j < q.length; j++) {
                int nextDepth = q[j];

                while (currentDepth < nextDepth) {
                    System.out.print("(");
                    currentDepth++;
                }
                while (currentDepth > nextDepth) {
                    System.out.print(")");
                    currentDepth--;
                }
                System.out.print(nextDepth);
            }

            while (currentDepth > 0) {
                System.out.print(")");
                currentDepth--;
            }
            System.out.println();
        }
        scanner.close();
    }
}