import java.io.*;
import java.util.*;

public class Solution {
    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = stoi(br.readLine());

        for (int i = 1; i <= T; ++i) {
            sb.append(String.format("Case #%d: ", i));

            int U = stoi(br.readLine());
            Map<Long, List<String>> digitToChars = new HashMap<>();

            for (long j = 0; j < 10; ++j) {
                digitToChars.put(j, new ArrayList<>());
            }

            for (int j = 0; j < 10000; ++j) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                long Q = Long.parseLong(st.nextToken());
                String[] R = st.nextToken().split("");
                boolean isLargeQ = Q >= 10;

                if (isLargeQ) {
                    if (!digitToChars.get(0L).contains(R[R.length - 1])) {
                        digitToChars.get(0L).add(R[R.length - 1]);
                    }
                } else {
                    Q %= 10;
                    if (!digitToChars.get(Q).contains(R[R.length - 1])) {
                        digitToChars.get(Q).add(R[R.length - 1]);
                    }
                }
            }

            StringBuilder out = new StringBuilder();
            for (long j = 1; j < 10; ++j) {
                String x = digitToChars.get(j).get(0);
                out.append(x);
                digitToChars.get(0L).remove(x);

                for (long k = j + 1; k < 10; k++) {
                    digitToChars.get(k).remove(x);
                }
            }
            out.insert(0, digitToChars.get(0L).get(0));
            sb.append(out.toString()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}