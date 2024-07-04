import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int numberOfTests = input.nextInt();
        int numberOfBytes = input.nextInt();

        int bytes[] = new int[10];

        for (int test = 0; test < numberOfTests; test++) {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1);
                bytes[i] = input.nextInt();
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                stringBuilder.append(bytes[i]);
            }
            System.out.println(stringBuilder.toString());
            input.next();
        }
    }
}
