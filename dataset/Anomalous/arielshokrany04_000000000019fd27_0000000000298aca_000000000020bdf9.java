package matrix;

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
        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= T; ++i) {
            int N = Integer.parseInt(input.nextLine());
            initializeArrays(N);
            for (int j = 0; j < N; j++) {
                addTime(input.nextLine(), j);
            }
            output.append(solve(i, N)).append("\n");
        }
        System.out.print(output.toString());
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
        if (canAddToC(j)) {
            add(cEnd, end[j]);
            return 'C';
        } else if (canAddToJ(j)) {
            add(jEnd, end[j]);
            return 'J';
        } else {
            return 'e';
        }
    }

    private static boolean canAddToC(int j) {
        for (int i = 0; i < cEnd.length && cEnd[i] != -1; i++) {
            if (overlaps(cStart[i], cEnd[i], start[j], end[j])) {
                return false;
            }
        }
        return true;
    }

    private static boolean canAddToJ(int j) {
        for (int i = 0; i < jEnd.length && jEnd[i] != -1; i++) {
            if (overlaps(jStart[i], jEnd[i], start[j], end[j])) {
                return false;
            }
        }
        return true;
    }

    private static boolean overlaps(int start1, int end1, int start2, int end2) {
        return (end1 > start2 && end2 > start1);
    }

    public static String solve(int num, int count) {
        StringBuilder result = new StringBuilder();
        result.append('C');
        cEnd[0] = end[0];
        cStart[0] = start[0];
        for (int j = 1; j < count; j++) {
            char ch = addJC(j);
            if (ch == 'e') {
                return "Case #" + num + ": IMPOSSIBLE";
            }
            result.append(ch);
        }
        return "Case #" + num + ": " + result.toString();
    }

    public static void add(int[] array, int n) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) {
                array[i] = n;
                break;
            }
        }
    }
}