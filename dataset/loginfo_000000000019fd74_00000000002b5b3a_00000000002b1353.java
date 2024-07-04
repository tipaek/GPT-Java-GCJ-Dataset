import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();
            int T = Integer.parseInt(br.readLine());

            for (int t = 1; t <= T; t++) {
                int N = Integer.parseInt(br.readLine());

                sb.append(String.format("Case #%d:\n", t));
                for (int i = 1; i <= N; i++) {
                    sb.append(i).append(' ').append(1).append('\n');
                }
            }
            
            bw.write(sb.toString());
            bw.flush();
        }
    }


}
