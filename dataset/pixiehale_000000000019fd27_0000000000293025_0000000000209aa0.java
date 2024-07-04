import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str[] = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            if (k%n==0){
                sb.append("Case #").append(i+1).append(": POSSIBLE\n");
                int d = k/n;
                int a[][] = new int[n][n];
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < n; l++) {
                        sb.append((n+d-j+l-1)%n +1 ).append(" ");
                    }
                    sb.append("\n");
                }

            } else {
                sb.append("Case #").append(i+1).append(": IMPOSSIBLE\n");
            }
        }
        System.out.println(sb);
    }
}
