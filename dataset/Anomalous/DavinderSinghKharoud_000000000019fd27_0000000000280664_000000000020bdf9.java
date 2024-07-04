import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static String solve(int[][] activities) {
        StringBuilder result = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();

        if (activities.length == 0) {
            return "";
        }

        // Sort the activities by start time
        Arrays.sort(activities, Comparator.comparingInt(o -> o[0]));

        map.put("J", activities[0][1]);
        map.put("C", 0);
        result.append("J");

        for (int i = 1; i < activities.length; i++) {
            int start = activities[i][0];
            int end = activities[i][1];

            int jimEnd = map.get("J");
            int camEnd = map.get("C");

            if (start < jimEnd && start < camEnd) {
                return "IMPOSSIBLE";
            }

            if (start >= camEnd) {
                result.append("C");
                map.put("C", end);
            } else {
                result.append("J");
                map.put("J", end);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        int caseNum = fastReader.nextInt();
        for (int ks = 1; ks <= caseNum; ks++) {
            int len = fastReader.nextInt();
            int[][] activities = new int[len][2];

            for (int i = 0; i < len; i++) {
                activities[i][0] = fastReader.nextInt();
                activities[i][1] = fastReader.nextInt();
            }

            System.out.println(String.format("Case #%d: %s", ks, solve(activities)));
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}