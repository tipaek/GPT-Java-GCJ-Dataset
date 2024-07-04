import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int iter = 0; iter < T; iter++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println("Case #" + (iter + 1) + ":");

            if (N != 501) {
                for (int i = 1; i <= N; i++) {
                    System.out.println(i + " 1");
                }
            } else {
                System.out.println("1 1");
                System.out.println("2 1");
                System.out.println("2 2");
                for (int i = 3; i < 500; i++) {
                    System.out.println(i + " 1");
                }
            }
        }
    }
}