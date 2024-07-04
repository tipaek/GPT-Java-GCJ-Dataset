import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            System.out.println("Case #" + (t + 1) + ": ");
            
            if (N == 1) {
                System.out.println("1 1");
            } else {
                int halfN = N / 2;

                if (N <= 998) {
                    for (int i = 0; i < halfN; i++) {
                        System.out.println((i + 1) + " " + (i + 1));
                        if (i == 0 && N % 2 == 1) {
                            System.out.println("2 1");
                        }
                    }
                    if (N != 3) {
                        System.out.println((halfN + 1) + " " + halfN);
                    } else {
                        System.out.println("3 1");
                    }
                } else if (N <= 1000) {
                    for (int i = 0; i < 498; i++) {
                        if (i == 3 && N == 999) {
                            System.out.println("4 3");
                        }
                        if (i == 4 && N == 1000) {
                            System.out.println("5 4");
                        }
                        System.out.println((i + 1) + " " + (i + 1));
                    }
                    System.out.println("499 498");
                }
            }
        }

        sc.close();
    }
}