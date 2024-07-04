import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    static int log2(int N) {
        return (int)(Math.log(N) / Math.log(2));
    }

    static int choose(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        return choose(n - 1, k - 1) + choose(n - 1, k);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int iter = 0; iter < T; iter++) {
            System.out.println("Case #" + (iter + 1) + ":");
            int N = Integer.parseInt(br.readLine());
            int pasos = 0;

            int cantFilas = log2(N + 1);

            for (int i = 1; i <= cantFilas; i++) {
                if (i % 2 == 0) {
                    for (int j = 1; j <= i; j++) {
                        System.out.println(i + " " + j);
                        pasos++;
                    }
                } else {
                    for (int j = i; j >= 1; j--) {
                        System.out.println(i + " " + j);
                        pasos++;
                    }
                }
            }

            if (N < 960) {
                int diff = (int) Math.pow(2, cantFilas - 1) - 1;
                diff = N - diff;

                for (int k = 0; k < diff; k++) {
                    if (cantFilas % 2 == 1) {
                        System.out.println((cantFilas + k + 1) + " " + 1);
                        pasos++;
                    } else {
                        System.out.println((cantFilas + k + 1) + " " + (cantFilas + k + 1));
                        pasos++;
                    }
                }
            } else {
                int total = 255;
                for (int i = 10; i <= 38; i++) {
                    System.out.println(i + " " + 2);
                    total += i - 1;
                    pasos++;
                }

                int diff = N - 922;
                for (int k = 38; k < diff + 38; k++) {
                    System.out.println(k + " " + 1);
                    total += 1;
                    pasos++;
                }
            }
        }
    }
}