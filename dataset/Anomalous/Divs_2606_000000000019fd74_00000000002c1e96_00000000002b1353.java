import java.util.Scanner;

public class Solution {
    static int factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    static int ncr(int n, int r) {
        return factorial(n) / (factorial(n - r) * factorial(r));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int d = 0; d < t; d++) {
            int sum1 = sc.nextInt();
            System.out.println("Case #" + (d + 1));
            int n = 4;
            int sum = sum1 - 1;

            outerLoop:
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (sum == 0) {
                        System.out.println((i + 1) + " " + (j + 1));
                        break outerLoop;
                    } else if (sum == ncr(i + 1, j + 1)) {
                        if (i != j) {
                            System.out.println((i + 1) + " " + (j + 1));
                            System.out.println((i + 2) + " " + (j + 2));
                        } else {
                            System.out.println((i + 1) + " " + (j + 1));
                            System.out.println(i + " " + j);
                        }
                        break outerLoop;
                    } else if (sum > ncr(i + 1, j + 1)) {
                        if ((i + 1) % 2 == 0) {
                            j = (i + 1) / 2;
                            System.out.println((i + 1) + " " + j);
                            sum -= ncr(i, j - 1);
                            i++;
                        } else {
                            j = i / 2;
                            System.out.println((i + 1) + " " + (j + 1));
                            sum -= ncr(i, j);
                            if (i != 4) {
                                i++;
                            } else {
                                System.out.println((i + 1) + " " + (i - j));
                                sum -= ncr(i, j + 1);
                                if (j + 1 == i) {
                                    i--;
                                    j--;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}