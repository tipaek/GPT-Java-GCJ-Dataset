import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    // Function to compute log base 2 of a number
    static int log2(int N) {
        return (int) (Math.log(N) / Math.log(2));
    }

    // Function to compute binomial coefficient (n choose k)
    static int choose(int n, int k) {
        if (k == 0 || k == n)
            return 1;
        return choose(n - 1, k - 1) + choose(n - 1, k);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int iter = 0; iter < T; iter++) {
            System.out.println("Case #" + (iter + 1) + ":");
            int N = Integer.parseInt(br.readLine());

            if (N == 1) {
                System.out.println(1 + " " + 1);
            } else {
                System.out.println(1 + " " + 1);
                N--;
                int total = 0;
                int index = 2;
                int steps = 0;

                while (true) {
                    if (total + index < N) {
                        System.out.println(index + " " + 2);
                        total += index - 1;
                        index++;
                        steps++;
                    } else {
                        break;
                    }
                }

                index--;

                for (int i = 0; i < N - total; ++i) {
                    System.out.println(index + " " + 1);
                    index++;
                }
            }
        }
    }
}