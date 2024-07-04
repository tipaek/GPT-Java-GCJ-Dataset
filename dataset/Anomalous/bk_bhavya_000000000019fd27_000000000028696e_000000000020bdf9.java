import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        int testCaseNumber = t;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n * 2];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            TreeMap<Integer, List<Integer>> timeMap = new TreeMap<>();
            for (int i = 0; i < arr.length; i++) {
                timeMap.putIfAbsent(arr[i], new ArrayList<>());
                timeMap.get(arr[i]).add(i % 2 == 0 ? 1 : 2);
            }

            StringBuilder schedule = new StringBuilder();
            int balance = 0;
            boolean impossible = false;

            for (Map.Entry<Integer, List<Integer>> entry : timeMap.entrySet()) {
                List<Integer> events = entry.getValue();
                for (int event : events) {
                    if (event == 1) {
                        balance++;
                        if (balance == 1) {
                            schedule.append("C");
                        } else if (balance == 2) {
                            schedule.append("J");
                        } else if (balance > 2) {
                            impossible = true;
                            break;
                        }
                    } else {
                        balance--;
                    }
                }
                if (impossible) break;
            }

            while (balance < 0) {
                schedule.append("C");
                balance++;
            }

            if (impossible) {
                System.out.println("Case #" + (testCaseNumber - t) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (testCaseNumber - t) + ": " + schedule.toString());
            }
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