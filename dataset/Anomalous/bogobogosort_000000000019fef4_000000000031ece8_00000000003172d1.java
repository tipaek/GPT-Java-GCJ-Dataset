import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            writer.print("Case #" + (i + 1) + ": ");
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            long[] arr = new long[n];
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Long.parseLong(st.nextToken());
            }

            if (d == 2) {
                boolean duplicateFound = false;
                for (int j = 0; j < n && !duplicateFound; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (arr[j] == arr[k]) {
                            writer.println(0);
                            duplicateFound = true;
                            break;
                        }
                    }
                }
                if (!duplicateFound) {
                    writer.println(1);
                }
            } else {
                processForDGreaterThan2(writer, arr);
            }
        }

        reader.close();
        writer.close();
    }

    private static void processForDGreaterThan2(PrintWriter writer, long[] arr) {
        int n = arr.length;
        int same = 0;
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        long sameMin = Long.MAX_VALUE;
        boolean workfs = false;

        for (int j = 0; j < n; j++) {
            min = Math.min(min, arr[j]);
            max = Math.max(max, arr[j]);
            for (int k = j + 1; k < n; k++) {
                if (arr[j] / 2 == arr[k] || arr[k] / 2 == arr[j]) {
                    workfs = true;
                }
                if (arr[j] == arr[k]) {
                    same++;
                    sameMin = Math.min(sameMin, arr[j]);
                }
                for (int p = k + 1; p < n; p++) {
                    if (arr[j] == arr[k] && arr[k] == arr[p]) {
                        writer.println(0);
                        return;
                    }
                }
            }
        }

        if ((same > 0 && max > sameMin) || workfs) {
            writer.println(1);
        } else {
            writer.println(2);
        }
    }
}