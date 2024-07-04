import java.util.Scanner;
import java.io.IOException;

class Ques {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Ques ob = new Ques();

        System.out.println("Enter no. of test cases: ");
        int t = scanner.nextInt();
        while (t > 0) {
            System.out.println("Enter the size of square matrix: ");
            int n = scanner.nextInt();
            int sum = 0;
            int[][] A = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                sum += A[i][i];
            }

            System.out.print(sum + " ");
            ob.fun(A, n);
            t--;
        }
        scanner.close();
    }

    void fun(int[][] s, int n) {
        int v, c;
        String r = "", co = "";
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                v = s[i][j];
                c = 0;

                for (int k = 0; k < n; k++) {
                    if (v == s[i][k]) {
                        c++;
                    }
                }
                r += c;
                c = 0;

                for (int k = 0; k < n; k++) {
                    if (v == s[k][j]) {
                        c++;
                    }
                }
                co += c;
            }
        }

        for (int i = 0; i < r.length(); i++) {
            int h = Character.getNumericValue(r.charAt(i));
            if (h > max1) {
                max1 = h;
            }
        }

        for (int i = 0; i < co.length(); i++) {
            int h = Character.getNumericValue(co.charAt(i));
            if (h > max2) {
                max2 = h;
            }
        }

        System.out.print(max1 + " ");
        System.out.print(max2 + " ");
    }
}