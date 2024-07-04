import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        for (int ii = 1; ii <= T; ii++) {
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

            int[] b2 = new int[B];
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                b2[i - 1] = Integer.parseInt(sc.nextLine());
            }

            if (checkAndPrint(a1, b2, B, sc)) continue;
            if (checkAndPrint(a2, b2, B, sc)) continue;
            if (checkAndPrint(a3, b2, B, sc)) continue;
            if (checkAndPrint(a4, b2, B, sc)) continue;
        }
    }

    private static boolean checkAndPrint(int[] a, int[] b2, int B, Scanner sc) {
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            if ((b2[i] == a[i]) || (b2[i] == ~a[i])
                    || (b2[i] == a[B - i - 1]) || (b2[i] == ~a[B - i - 1])) {
                cnt++;
            }
        }

        if (cnt == 10) {
            StringBuilder s1 = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                s1.append(a[i]);
            }
            System.out.println(s1.toString());
            String output = sc.nextLine();
            return output.equals("Y");
        }
        return false;
    }
}