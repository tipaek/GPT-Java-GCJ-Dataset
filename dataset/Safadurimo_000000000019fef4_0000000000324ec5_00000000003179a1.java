import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.util.Comparator;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        MyScanner in = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Overrandomized solver = new Overrandomized();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Overrandomized {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int zehn = 10000;
            int u = in.nextInt();
            int[] q = new int[10000];
            String[] r = new String[10000];
            for (int j = 0; j < 10000; j++) {
                q[j] = in.nextInt();
                r[j] = in.next();
            }

            HashMap<Character, Integer> hm = new HashMap<>();

            for (int i = 0; i < zehn; i++) {
                char leading = r[i].charAt(0);
                if (!hm.containsKey(leading)) {
                    hm.put(leading, 1);
                } else hm.put(leading, hm.get(leading) + 1);
            }

            char zero = ' ';
            for (int i = 0; i < zehn; i++) {
                for (int j = 1; j < r[i].length(); j++) {
                    if (!hm.containsKey(r[i].charAt(j))) {
                        zero = r[i].charAt(j);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();

            sb.append(zero);


            Map<Character, Integer> sortedMap = new MapUtil().sortByValue(hm);
            for (char c : sortedMap.keySet()
            ) {
                sb.append(c);
            }


            out.printf("Case #%d: %s\n", testNumber, sb);

        }

        public class MapUtil {
            public <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
                List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
                list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

                Map<K, V> result = new LinkedHashMap<>();
                for (Map.Entry<K, V> entry : list) {
                    result.put(entry.getKey(), entry.getValue());
                }

                return result;
            }

        }

    }

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

