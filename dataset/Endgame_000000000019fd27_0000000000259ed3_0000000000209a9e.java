import java.util.Scanner;

public class Solution {
    static Scanner in = new Scanner(System.in);

    public static void main(String args[]) {
        int T = in.nextInt();
        int B = in.nextInt();
        int bitArray[] = new int[B];
        for (int i = 1; i <= T; i++) {
            String result = "";
            if (B == 10)
                secret10(bitArray);
            else if (B == 20)
                secret20(bitArray);
            else
                secret(B, bitArray);
//            System.out.println("Case #" + i + ": " + secret(B));
        }
    }

    private static void secret10(int[] bitArray) {
        String result = "";

        for (int bit = 1; bit <= 10; bit++) {
            System.out.println(bit);
            result += in.next().charAt(0);
        }

        System.out.println(result);
        in.next();
    }

    private static void secret20(int[] bitArray) {
        int B = 20;
        int P;
        StringBuilder result = new StringBuilder("");

        for (int i = 0; i < B / 2; i++) {
            P = i + 1;
            System.out.println(P);
            bitArray[P - 1] = in.next().charAt(0) - '0';
            P = B - i;
            System.out.println(P);
            bitArray[P - 1] = in.next().charAt(0) - '0';
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
            int leftVal = in.next().charAt(0) - '0';

            if (leftVal != bitArray[i]) {
                bitArray[i] = leftVal;
                bitArray[B - 1 - i] = (bitArray[B - 1 - i] + 1) % 2;
            }
        }

        for (int bit : bitArray) {
            result.append(bit);
        }

        System.out.println(result.toString());
        in.next();
    }

    private static void secret(int B, int[] bitArray) {
        System.exit(0);
    }
}
