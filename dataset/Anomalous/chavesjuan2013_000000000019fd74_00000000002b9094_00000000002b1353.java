import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    static int log2(int N) {
        return (int) (Math.log(N) / Math.log(2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int iter = 0; iter < T; iter++) {
            System.out.println("Case #" + (iter + 1) + ":");
            int N = Integer.parseInt(br.readLine());

            int cantFilas = log2(N + 1);

            for (int i = 1; i <= cantFilas; i++) {
                if (i % 2 == 0) {
                    for (int j = 1; j <= i; j++) {
                        System.out.println(i + " " + j);
                    }
                } else {
                    for (int j = i; j >= 1; j--) {
                        System.out.println(i + " " + j);
                    }
                }
            }

            int diff = N - ((1 << cantFilas) - 1);

            for (int k = 0; k < diff; k++) {
                if (cantFilas % 2 == 1) {
                    System.out.println((cantFilas + k + 1) + " " + 1);
                } else {
                    System.out.println((cantFilas + k + 1) + " " + (cantFilas + k + 1));
                }
            }
        }
    }
}