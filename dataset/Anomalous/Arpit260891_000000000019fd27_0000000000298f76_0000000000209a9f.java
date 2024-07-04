import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int count = 1; count <= t; count++) {
            StringBuilder Snew = new StringBuilder();
            String[] S = br.readLine().split("");
            int prev = 0;

            for (int i = 0; i < S.length; i++) {
                int k = Integer.parseInt(S[i]);
                if (k > prev) {
                    Snew.append(addOpen(k - prev));
                } else if (k < prev) {
                    Snew.append(addClose(prev - k));
                }
                Snew.append(S[i]);
                prev = k;
            }
            Snew.append(addClose(prev));

            System.out.println("Case #" + count + ": " + Snew);
        }
    }

    private static String addOpen(int n) {
        return "(".repeat(n);
    }

    private static String addClose(int n) {
        return ")".repeat(n);
    }
}