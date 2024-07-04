import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static final String IMPOSSIBLE = "IMPOSSIBLE";

    // return the activity index with smallest end time
    public static int getMinimumActivityIdx(int[] end, boolean[] isProcessed, int n) {
        int min = 1440, idx = -1;
        for (int i = 0; i < n; ++i) {
            if (isProcessed[i] == false && end[i] <= min) {
                min = end[i];
                idx = i;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        FastReader cin = new FastReader();
        int tc = cin.nextInt();

        int[] start = new int[1000];
        int[] end = new int[1000];
        boolean[] isProcessed = new boolean[1000];

        int n;

        for (int t = 1; t <= tc; ++t) {
            n = cin.nextInt();
            for (int i = 0; i < n; ++i) {
                start[i] = cin .nextInt();
                end[i] = cin.nextInt();
                isProcessed[i] = false;
            }

            List<Integer> jamie = new ArrayList<>();
            List<Integer> cameron = new ArrayList<>();
            boolean isImpossible = false;

            while (true) {
                int minIdx = getMinimumActivityIdx(end, isProcessed, n);
                if (minIdx == -1) {
                    break;
                }
                isProcessed[minIdx] = true;
                if (jamie.isEmpty()) {
                    jamie.add(minIdx);
                } else {
                    int lastIdx = jamie.get(jamie.size() - 1);
                    int endTimeLastAct = end[lastIdx];
                    int startTimeNextAct = start[minIdx];
                    if (endTimeLastAct <= startTimeNextAct) {
                        jamie.add(minIdx);
                    } else {
                        if (cameron.isEmpty()) {
                            cameron.add(minIdx);
                        } else {
                            lastIdx = cameron.get(cameron.size() - 1);
                            endTimeLastAct = end[lastIdx];
                            if (endTimeLastAct <= startTimeNextAct) {
                                cameron.add(minIdx);
                            } else {
                                isImpossible = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (isImpossible) {
                System.out.println("Case #" + t + ": " + IMPOSSIBLE);
            } else {
                StringBuilder result = new StringBuilder();
                result.setLength(n);
                for (Integer jam : jamie) {
                    result.setCharAt(jam, 'J');
                }
                for (Integer cam : cameron) {
                    result.setCharAt(cam, 'C');
                }
                System.out.println("Case #" + t + ": " + result.toString());
            }
        }
    }

    // FastReader class
    // credit goes to GeeksForGeeks
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
