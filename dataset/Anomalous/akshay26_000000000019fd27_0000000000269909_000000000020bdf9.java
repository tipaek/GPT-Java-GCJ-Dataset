import java.util.*;
import java.io.*;

class Name implements Comparable<Name> {
    private int startTime;
    private int endTime;
    private int index;

    public Name(int startTime, int endTime, int index) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.index = index;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Name other) {
        if (this.startTime != other.startTime) {
            return this.startTime - other.startTime;
        } else {
            return this.endTime - other.endTime;
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int testCases = sc.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = sc.nextInt();
            Name[] intervals = new Name[n];
            int[] indices = new int[n];

            for (int i = 0; i < n; i++) {
                intervals[i] = new Name(sc.nextInt(), sc.nextInt(), i);
                indices[i] = i;
            }

            Arrays.sort(intervals);

            Map<Integer, String> assignment = new HashMap<>();
            int endC = 0, endJ = 0;
            boolean impossible = false;

            for (Name interval : intervals) {
                int start = interval.getStartTime();
                int end = interval.getEndTime();
                int idx = interval.getIndex();

                if (endC <= start) {
                    assignment.put(idx, "C");
                    endC = end;
                } else if (endJ <= start) {
                    assignment.put(idx, "J");
                    endJ = end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + t + ": ");
                for (int i = 0; i < n; i++) {
                    System.out.print(assignment.get(indices[i]));
                }
                System.out.println();
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