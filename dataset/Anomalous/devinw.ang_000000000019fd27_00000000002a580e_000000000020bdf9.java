import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            solve(i + 1, sc, out);
        }
        out.close();
    }

    public static void solve(int testNumber, FastReader sc, PrintWriter pw) {
        int n = sc.nextInt();
        Event[] events = new Event[n * 2];
        int[] test = new int[n * 2];
        int index = 0;

        for (int i = 0; i < events.length; i += 2) {
            events[i] = new Event(sc.nextInt(), index + 1);
            events[i + 1] = new Event(sc.nextInt(), -index - 1);
            index++;
            test[i] = events[i].time;
            test[i + 1] = events[i + 1].time;
        }

        Arrays.sort(events);
        ArrayList<Integer> C = new ArrayList<>();
        ArrayList<Integer> J = new ArrayList<>();
        int cCount = 0, jCount = 0;
        int cIndex = 0, jIndex = 0;

        for (Event event : events) {
            if (event.index > 0) {
                if (cCount == 0) {
                    cIndex = event.index;
                    cCount++;
                    C.add(event.index);
                } else if (jCount == 0) {
                    jIndex = event.index;
                    jCount++;
                    J.add(event.index);
                } else {
                    pw.printf("Case #%d: IMPOSSIBLE%n", testNumber);
                    return;
                }
            } else {
                if (Math.abs(event.index) == cIndex) {
                    cCount = 0;
                } else if (Math.abs(event.index) == jIndex) {
                    jCount = 0;
                }
            }
        }

        pw.print("Case #" + testNumber + ": ");
        for (int x = 1; x <= n; x++) {
            if (C.contains(x)) {
                pw.print("C");
            } else {
                pw.print("J");
            }
        }
        pw.println();
    }

    public static boolean works(int[] arr, ArrayList<Integer> min, ArrayList<Integer> max) {
        for (int i = 0; i < min.size(); i++) {
            if ((arr[0] > min.get(i) && arr[0] < max.get(i)) || arr[0] == min.get(i) || 
                (arr[1] > min.get(i) && arr[1] < max.get(i)) || arr[1] == max.get(i) || 
                (arr[0] > min.get(i) && arr[1] < max.get(i)) || 
                (arr[0] < min.get(i) && arr[1] > max.get(i))) {
                return false;
            }
        }
        return true;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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

    static class Event implements Comparable<Event> {
        int time, index;

        Event(int time, int index) {
            this.time = time;
            this.index = index;
        }

        @Override
        public int compareTo(Event other) {
            if (this.time == other.time) {
                return Integer.compare(this.index, other.index);
            } else {
                return Integer.compare(this.time, other.time);
            }
        }
    }
}