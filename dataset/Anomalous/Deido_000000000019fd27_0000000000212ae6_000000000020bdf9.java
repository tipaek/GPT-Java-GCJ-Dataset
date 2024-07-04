import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        int t = in.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = in.nextInt();
            int[][] tasks = new int[n][3];
            for (int i = 0; i < n; i++) {
                tasks[i][0] = i;
                tasks[i][1] = in.nextInt();
                tasks[i][2] = in.nextInt();
            }
            Arrays.sort(tasks, (task1, task2) -> Integer.compare(task1[2], task2[2]));

            char[] schedule = new char[n];
            int endC = 0, endJ = 0;
            boolean possible = true;

            for (int[] task : tasks) {
                if (task[1] >= endC) {
                    schedule[task[0]] = 'C';
                    endC = task[2];
                } else if (task[1] >= endJ) {
                    schedule[task[0]] = 'J';
                    endJ = task[2];
                } else {
                    possible = false;
                    break;
                }
            }
            System.out.println("Case #" + tc + ": " + (possible ? new String(schedule) : "IMPOSSIBLE"));
        }
    }
}

class FastReader {
    private final BufferedReader br;
    private StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private String next() {
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

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    public long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
    }

    public double[] nextDoubleArray(int n) {
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextDouble();
        }
        return array;
    }

    public String[] nextStringArray(int n) {
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = next();
        }
        return array;
    }
}