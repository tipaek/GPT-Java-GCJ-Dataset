import java.util.Scanner;
import java.io.*;

class Solution {
    private static int[] start;
    private static int[] end;
    private static int[] cEnd;
    private static int[] jEnd;
    private static int[] cStart;
    private static int[] jStart;
    private static final Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int T = Integer.parseInt(input.nextLine());
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= T; ++i) {
            int N = Integer.parseInt(input.nextLine());
            initializeArrays(N);

            for (int j = 0; j < N; j++) {
                addTime(input.nextLine(), j);
            }

            String result = solve(i, N);
            if (i < T) {
                output.append(result).append("\n");
            } else {
                output.append(result);
            }
        }

        System.out.println(output);
    }

    private static void initializeArrays(int size) {
        start = new int[size];
        end = new int[size];
        cEnd = new int[size];
        jEnd = new int[size];
        cStart = new int[size];
        jStart = new int[size];

        for (int i = 0; i < size; i++) {
            cEnd[i] = -1;
            jEnd[i] = -1;
            cStart[i] = -1;
            jStart[i] = -1;
        }
    }

    private static void addTime(String time, int index) {
        String[] times = time.split(" ");
        start[index] = Integer.parseInt(times[0]);
        end[index] = Integer.parseInt(times[1]);
    }

    private static char addJC(int index) {
        for (int i = 0; i < cEnd.length && cEnd[i] != -1; i++) {
            if ((cEnd[i] > start[index] && end[index] > cStart[i]) || (cEnd[i] < start[index] && end[index] < cStart[i])) {
                for (int j = 0; j < jEnd.length && jEnd[j] != -1; j++) {
                    if ((jEnd[j] > start[index] && end[index] > jStart[j]) || (jEnd[j] < start[index] && end[index] < jStart[j])) {
                        return 'e';
                    }
                }
                add(jEnd, end[index]);
                return 'J';
            }
        }
        add(cEnd, end[index]);
        return 'C';
    }

    private static String solve(int caseNumber, int count) {
        StringBuilder result = new StringBuilder();
        result.append('C');
        cEnd[0] = end[0];
        cStart[0] = start[0];

        for (int j = 1; j < count; j++) {
            char ch = addJC(j);
            if (ch == 'e') {
                return "Case #" + caseNumber + ": IMPOSSIBLE";
            }
            result.append(ch);
        }
        return "Case #" + caseNumber + ": " + result.toString();
    }

    private static void add(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) {
                array[i] = value;
                break;
            }
        }
    }
}