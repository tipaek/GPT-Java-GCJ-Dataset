import java.util.Scanner;

public class Solution {

    private static Scanner input;

    private static String readBitsFromTo(int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) {
            System.out.println(i);
            System.out.flush();
            result.append(input.nextInt());
        }
        return result.toString();
    }

    public static void main(String args[]) {
        input = new Scanner(System.in);
        int T = input.nextInt();
        int b = input.nextInt();
        for (int tests = 1; tests <= T; tests++) {
            if (b == 10) {

                System.out.println(readBitsFromTo(1, 10));
                System.out.flush();
                input.next();
            } else if (b == 20) {
                String firstFive = readBitsFromTo(1, 5);
                String secondFive = readBitsFromTo(11, 15);
                String thirdFive = readBitsFromTo(11, 15);
            }
        }
    }
}