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
            return Integer.compare(this.startTime, other.startTime);
        }
        return Integer.compare(this.endTime, other.endTime);
    }
}

public class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int testCases = sc.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = sc.nextInt();
            Name[] activities = new Name[n];
            int[] originalOrder = new int[n];

            for (int i = 0; i < n; i++) {
                activities[i] = new Name(sc.nextInt(), sc.nextInt(), i);
                originalOrder[i] = i;
            }

            boolean impossible = false;
            List<Name> activityList = new ArrayList<>(Arrays.asList(activities));
            Collections.sort(activityList);

            Map<Integer, String> assignment = new HashMap<>();
            int endC = -1, endJ = -1;

            for (Name activity : activityList) {
                int start = activity.getStartTime();
                int end = activity.getEndTime();
                int index = activity.getIndex();

                if (endC <= start) {
                    assignment.put(index, "C");
                    endC = end;
                } else if (endJ <= start) {
                    assignment.put(index, "J");
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
                    System.out.print(assignment.get(originalOrder[i]));
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