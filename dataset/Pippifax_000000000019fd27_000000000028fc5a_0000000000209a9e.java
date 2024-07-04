import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int numberOfTests = input.nextInt();
        int numberOfBytes = input.nextInt();

        int bytes[] = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            bytes[i] = input.nextInt();
        }
    }
}
