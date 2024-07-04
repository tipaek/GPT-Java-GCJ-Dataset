import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {

            int T = sc.nextInt();
            for (int testCase = 1; testCase <= T; testCase++) {
                int N = sc.nextInt();

                int[] cameron = {0, 0};
                int[] jamie = {0, 0};
                StringBuilder result = new StringBuilder();

                boolean possible = true;

                for (int n = 0; n < N; n++) {
                    int startTime = sc.nextInt();
                    int endTime = sc.nextInt();

                    if (startTime >= cameron[1]) {
                        result.append("C");
                        cameron[0] = startTime;
                        cameron[1] = endTime;
                    } else if (startTime >= jamie[1]) {
                        result.append("J");
                        jamie[0] = startTime;
                        jamie[1] = endTime;
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    System.out.println("Case #" + testCase + ": " + result);
                } else {
                    System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                }
            }
        }
    }
}