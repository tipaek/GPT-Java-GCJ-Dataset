import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] storage = new int[N][2];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                storage[j][0] = Integer.parseInt(st.nextToken());
                storage[j][1] = Integer.parseInt(st.nextToken());
            }

            List<String> assignments = new ArrayList<>();
            int[][] sortedByStart = sortByColumn(storage, 0);
            int[][] sortedSchedule = reSort(sortedByStart);

            String currentWorker = "J";
            int intersections = 0;

            for (int a = 0; a < N; a++) {
                for (int b = a + 1; b < N; b++) {
                    assignments.add(currentWorker);
                    if (checkIfOverlapping(sortedSchedule[a], sortedSchedule[b])) {
                        currentWorker = "C";
                        intersections++;
                    }
                }
            }

            if (intersections == sortedSchedule.length) {
                pw.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                StringBuilder sb = new StringBuilder();
                for (String assignment : assignments) {
                    sb.append(assignment);
                }
                pw.println("Case #" + i + ": " + sb.toString());
            }
        }
        pw.close();
    }

    public static boolean checkIfOverlapping(int[] interval1, int[] interval2) {
        return interval1[1] > interval2[0];
    }

    public static int[][] sortByColumn(int[][] array, int col) {
        Arrays.sort(array, Comparator.comparingInt(a -> a[col]));
        return array;
    }

    public static int[][] reSort(int[][] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i][0] == array[i - 1][0] && array[i - 1][1] > array[i][1]) {
                int temp = array[i][1];
                array[i][1] = array[i - 1][1];
                array[i - 1][1] = temp;
            }
        }
        return array;
    }
}