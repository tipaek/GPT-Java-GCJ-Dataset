import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        for (int testCase = 1; testCase <= T; testCase++) {
            int[] a1 = new int[B];
            int[] a2 = new int[B];
            int[] a3 = new int[B];
            int[] a4 = new int[B];

            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                int b1 = Integer.parseInt(sc.nextLine());
                a1[i - 1] = b1;
                a2[i - 1] = ~b1;
                a3[i - 1] = a1[B - 1];
                a4[i - 1] = ~a1[B - 1];
            }

            System.out.println(1);
            int b2 = Integer.parseInt(sc.nextLine());
            String s1 = "";

            if (b2 == a1[0]) {
                s1 = buildString(a1, 10);
            } else if (b2 == a2[0]) {
                s1 = buildString(a2, 10);
            } else if (b2 == a3[0]) {
                s1 = buildString(a3, 10);
            } else if (b2 == a4[0]) {
                s1 = buildString(a4, 10);
            }

            System.out.println(s1);

            String output = sc.nextLine();
            if (output.equals("Y")) {
                continue;
            }
        }
    }

    private static String buildString(int[] array, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(array[i]);
        }
        return sb.toString();
    }
}