import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static String solve(int[][] activities) {
        if (activities.length == 0) {
            return "";
        }

        Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

        StringBuilder result = new StringBuilder();
        int[] endTimes = new int[2]; // endTimes[0] for J, endTimes[1] for C

        endTimes[0] = activities[0][1];
        result.append("J");

        for (int i = 1; i < activities.length; i++) {
            int start = activities[i][0];
            int end = activities[i][1];

            if (start >= endTimes[0]) {
                result.append("J");
                endTimes[0] = end;
            } else if (start >= endTimes[1]) {
                result.append("C");
                endTimes[1] = end;
            } else {
                return "IMPOSSIBLE";
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
}

class FastReader {
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