
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void down(int n) {
        int x = 1;

        for (int i = 0; i < n; i++) {
            System.out.printf(String.format("%d 1\n", x));
            x += 1;
        }
    }


    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int cases = Integer.parseInt(scan.nextLine());





        for (int i = 0; i < cases; i++) {

            System.out.println("Case #" + (i + 1));
            int N = Integer.parseInt(scan.nextLine());


            if (N <= 500) {
                down(N);
            } else if (N <= 998) {
                if (N % 2 == 0) {
                    int e = N/2;
                    down(e);
                    System.out.printf(String.format("%d 2\n", e + 1));
                } else {
                    int e = (N + 1)/2;
                    down(e);
                    System.out.printf(String.format("%d 2\n", e));
                }
            } else {
                // 12 steps
                System.out.println("1 1");
                System.out.println("2 1");
                System.out.println("3 1");
                System.out.println("4 1");
                System.out.println("5 1");
                System.out.println("6 1");
                System.out.println("7 1");
                System.out.println("8 2");
                System.out.println("9 3");
                System.out.println("10 4");
                System.out.println("11 5");
                System.out.println("12 5");
                System.out.println("12 4");
                System.out.println("12 3");
                System.out.println("12 2");
                System.out.println("12 1");

                int rem = N - 898;
                int e = 13;

                for (int u = 0; u < rem; u++) {
                    System.out.printf(String.format("%d 1\n", e + 1));
                    e += 1;
                }
            }


        }
    }
}
