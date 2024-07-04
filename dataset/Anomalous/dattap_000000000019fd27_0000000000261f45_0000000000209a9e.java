import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        outerLoop: for (int testCase = 1; testCase <= T; testCase++) {
            int[] a1 = new int[B];
            int[] a2 = new int[B];
            int[] a3 = new int[B];
            int[] a4 = new int[B];

            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                int b1 = Integer.parseInt(sc.nextLine());
                a1[i - 1] = b1;
                a2[i - 1] = ~b1;
                a3[i - 1] = a1[B - i];
                a4[i - 1] = ~a1[B - i];
            }

            System.out.println(1);
            int b2 = Integer.parseInt(sc.nextLine());

            System.out.println(2);
            int b3 = Integer.parseInt(sc.nextLine());

            if (isValid(b2, b3, a1, B)) {
                if (processOutput(sc, a1)) {
                    continue outerLoop;
                } else {
                    break;
                }
            }

            if (isValid(b2, b3, a2, B)) {
                if (processOutput(sc, a2)) {
                    continue outerLoop;
                } else {
                    break;
                }
            }

            if (isValid(b2, b3, a3, B)) {
                if (processOutput(sc, a3)) {
                    continue outerLoop;
                } else {
                    break;
                }
            }

            if (isValid(b2, b3, a4, B)) {
                if (processOutput(sc, a4)) {
                    continue outerLoop;
                } else {
                    break;
                }
            }
        }
    }

    private static boolean isValid(int b2, int b3, int[] array, int B) {
        return (b2 == array[0] && b3 == array[1]) ||
               (b2 == ~array[0] && b3 == ~array[1]) ||
               (b2 == array[B - 1] && b3 == array[B - 2]) ||
               (b2 == ~array[B - 1] && b3 == ~array[B - 2]);
    }

    private static boolean processOutput(Scanner sc, int[] array) {
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            s1.append(array[i]);
        }
        System.out.println(s1.toString());
        String output = sc.nextLine();
        return output.equals("Y");
    }
}