import java.util.Scanner;
import java.io.*;

class Solution {
    public static String out;
    public static int[] start;
    public static int[] end;
    public static int[] cEnd;
    public static int[] jEnd;
    public static int[] cStart;
    public static int[] jStart;
    static Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int T = Integer.parseInt(input.nextLine());
        StringBuilder out = new StringBuilder();

        for (int i = 1; i <= T; ++i) {
            int N = Integer.parseInt(input.nextLine());
            initializeArrays(N);

            for (int j = 0; j < N; j++) {
                addTime(input.nextLine(), j);
            }

            out.append(solve(i, N)).append("\n");
        }

        System.out.print(out.toString());
    }

    private static void initializeArrays(int N) {
        start = new int[N];
        end = new int[N];
        cEnd = new int[N];
        jEnd = new int[N];
        cStart = new int[N];
        jStart = new int[N];

        for (int j = 0; j < N; j++) {
            cEnd[j] = -1;
            jEnd[j] = -1;
            cStart[j] = -1;
            jStart[j] = -1;
        }
    }

    public static void addTime(String time, int place) {
        String[] times = time.split(" ");
        start[place] = Integer.parseInt(times[0]);
        end[place] = Integer.parseInt(times[1]);
    }

    public static char addJC(int j) {
        int i = 0;
        while (cEnd[i] != -1) {
            if (cEnd[i] > start[j] && end[j] > cStart[i]) {
                int i2 = 0;
                while (jEnd[i2] != -1) {
                    if (jEnd[i2] > start[j] && end[j] > jStart[i2]) {
                        return 'e';
                    }
                    i2++;
                }
                add(jEnd, end[j]);
                return 'J';
            }
            i++;
        }
        add(cEnd, end[j]);
        return 'C';
    }

    public static String solve(int num, int count) {
        StringBuilder out = new StringBuilder();
        out.append('C');
        cEnd[0] = end[0];
        cStart[0] = start[0];

        for (int j = 1; j < count; j++) {
            char ch = addJC(j);
            if (ch == 'e')
                return "Case #" + num + ": IMPOSSIBLE";
            out.append(ch);
        }

        return "Case #" + num + ": " + out.toString();
    }

    public static void add(int[] array, int n) {
        int i = 0;
        while (array[i] != -1) {
            i++;
        }
        array[i] = n;
    }
}