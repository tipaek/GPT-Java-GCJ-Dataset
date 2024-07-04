

import java.math.BigInteger;
import java.util.Scanner;

 class Solution {
    public static void main(String[] args) {
        test();
        Scanner in = new Scanner(System.in);
        String[] parts = in.nextLine().split(" ");
        int t = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);
        for (int i = 1; i <= t; i++) {
            if (b <= 10) {
                solveA(in, b);
            } else if (b <= 20) {
                solveB(in, b);
            } else {
                solveC(in, b);
            }
            String s = in.nextLine();
            if (!s.equalsIgnoreCase("Y")) {
                System.exit(0);
            }
        }
    }

    private static void test() {
    }

    private static void solveA(Scanner in, int b) {
        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= b; i++) {
            System.out.println(i);
            output.append(Integer.parseInt(in.nextLine()));
        }
        System.out.println(output.toString());

    }

    private static void solveB(Scanner in, int b) {
        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            output.append(Integer.parseInt(in.nextLine()));
        }
        boolean flag = true;
        String front = output.toString();
        while (true) {
            if (flag) {
                StringBuilder back = new StringBuilder();
                for (int i = 11; i <= 20; i++) {
                    System.out.println(i);
                    back.append(Integer.parseInt(in.nextLine()));
                }
                String str = back.toString();
                if (str.equalsIgnoreCase(front)) {
                    System.out.println(front + str);
                    break;
                } else {
                    front = str;
                    flag = false;
                }

            } else {
                StringBuilder frontBuilder = new StringBuilder();
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i);
                    frontBuilder.append(Integer.parseInt(in.nextLine()));
                }
                String str = frontBuilder.toString();
                if (str.equalsIgnoreCase(front)) {
                    System.out.println(str + front);
                    break;
                } else {
                    front = str;
                    flag = true;
                }
            }
        }
    }

    private static void solveC(Scanner in, int b) {
        System.exit(0);

    }

    private String complement(String binaryString) {
        BigInteger twoToLength = new BigInteger("2").pow(binaryString.length());
        String b = twoToLength.add(new BigInteger(binaryString, 2).not()).toString(2);
        return b;
    }
}
