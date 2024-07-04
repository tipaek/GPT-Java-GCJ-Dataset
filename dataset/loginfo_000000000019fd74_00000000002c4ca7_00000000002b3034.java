import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int T = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            for (int t = 1; t <= T; t++) {
                int N = Integer.parseInt(br.readLine());
                String[] strs = new String[N];
                int max = Integer.MIN_VALUE;
                int maxIdx = -1;
                String maxString = "";
                for (int i = 0; i < N; i++) {
                    String s = br.readLine();
                    strs[i] = s.substring(1);
                    if (max < s.length()) {
                        maxIdx = i;
                        maxString = strs[i];
                        max = s.length();
                    }
                }
                boolean is = true;
                for (String s : strs) {
                    if (!maxString.endsWith(s)) {
                        is = false;
                    }
                }
                String result = "*";
                if (is) {
                    result = maxString;
                }
                sb.append(String.format("Case #%d: %s\n", t, result));
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
}
