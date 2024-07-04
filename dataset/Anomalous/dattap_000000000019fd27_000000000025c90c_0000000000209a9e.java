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
                a3[i - 1] = a1[B - 1];
                a4[i - 1] = ~a1[B - 1];
            }

            if (ii == 11) {
                System.out.println(1);
                int b2 = Integer.parseInt(sc.nextLine());
                StringBuilder s1 = new StringBuilder();

                if (b2 == a1[0]) {
                    for (int i = 0; i < 10; i++) {
                        s1.append(a1[i]);
                    }
                    System.out.println(s1.toString());
                } else if (b2 == a2[0]) {
                    for (int i = 0; i < 10; i++) {
                        s1.append(a2[i]);
                    }
                    System.out.println(s1.toString());
                } else if (b2 == a3[0]) {
                    for (int i = 0; i < 10; i++) {
                        s1.append(a3[i]);
                    }
                    System.out.println(s1.toString());
                } else if (b2 == a4[0]) {
                    for (int i = 0; i < 10; i++) {
                        s1.append(a4[i]);
                    }
                    System.out.println(s1.toString());
                }
            }

            String output = sc.nextLine();
            if (output.equals("Y")) {
                continue;
            }
        }
    }
}