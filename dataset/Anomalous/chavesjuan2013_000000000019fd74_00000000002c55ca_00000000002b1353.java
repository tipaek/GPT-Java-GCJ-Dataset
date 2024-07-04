import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
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

                while (total + index < N) {
                    System.out.println(index + " " + 2);
                    total += index - 1;
                    index++;
                }

                index--;

                for (int i = 0; i < N - total; i++) {
                    System.out.println(index + " " + 1);
                    index++;
                }
            }
        }
    }
}