import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        ModScanner ms = new ModScanner();
        int t = ms.nextInt();
        int tc = 0;
        while (t-- > 0) {
            tc++;
            int u = ms.nextInt();
            String[] m = new String[10000];
            String[] r = new String[10000];

            Map<Character, Long> characterIntegerMap = new HashMap<>();
            for (int i = 0; i < 10000; i++) {
                m[i] = ms.nextToken();
                if (Long.valueOf(m[i]) != -1) {
                    r[i] = ms.nextToken();
                    if (characterIntegerMap.size() < 10) {
                    for (int j = 0; j < r[i].length(); j++) {
                        characterIntegerMap.putIfAbsent(r[i].charAt(j), Long.MAX_VALUE);
                    }
                }
                } else {
                    r[i] = "UNKNOWN";
                }
            }
            for (int i = 0; i < 10000; i++) {
                if (r[i] != "UNKNOWN") {
                long mi;
                if (r[i].length() == m[i].length()) {
                    mi = Long.valueOf(m[i].substring(0,1));
                } else {
                    mi = Long.valueOf(m[i]);
                }
                characterIntegerMap.compute(r[i].charAt(0), (k,v) -> mi < v ? mi : v);
                }
            }
            char[] ans = new char[10];
            for(Map.Entry<Character, Long> entry : characterIntegerMap.entrySet()) {
                if (entry.getValue() != Long.MAX_VALUE && entry.getValue() < 10) {
                    ans[Math.toIntExact(entry.getValue())] = entry.getKey();
                } else {
                    ans[0] = entry.getKey();
                }
            }
            System.out.println("Case #"+tc+": "+ new String(ans));

        }
    }
}


class ModScanner {
    BufferedReader br;
    StringTokenizer st;

    public ModScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String nextToken() throws Exception {
        while (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(br.readLine());

        }
        return st.nextToken();
    }

    String nextString() throws Exception {
        return br.readLine();
    }


    int nextInt() throws Exception, Exception {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }

}