import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int t = Integer.parseInt(input[0]);
        int a = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);

        for (int i = 0; i < t; i++) {
            solve(a, b);
        }
    }

    private static void solve(int A, int B) throws IOException {
        int xmid = 0, ymid = 0;
        for (int r = xmid - 6; r <= xmid + 6; r++) {
            for (int c = ymid - 6; c <= ymid + 6; c++) {
                System.out.println(r + " " + c);
                String response = br.readLine();
                if ("CENTER".equals(response)) {
                    return;
                }
            }
        }
    }
}