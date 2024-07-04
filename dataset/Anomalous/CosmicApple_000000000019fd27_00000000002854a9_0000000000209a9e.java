import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        int length = scanner.nextInt();

        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            int[] array = new int[10];

            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                array[i] = scanner.nextInt();
            }

            StringBuilder output = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                output.append(array[i]);
            }

            System.out.println(output.toString());
            scanner.next();
        }
    }
}