import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            boolean[] cameron = new boolean[1441];
            boolean[] jamie = new boolean[1441];
            String result = "";

            for (int n = 1; n <= N; n++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();

                if (result.equals("IMPOSSIBLE")) {
                    continue;
                }

                if (isAvailable(cameron, startTime, endTime)) {
                    result += "C";
                    fill(cameron, startTime, endTime);
                }
                else if (isAvailable(jamie, startTime, endTime)) {
                    result += "J";
                    fill(jamie, startTime, endTime);
                }
                else {
                    result = "IMPOSSIBLE";
                }
            }

            String line = "Case #" + test_case + ": " + result;
            System.out.println(line);
        }
    }

    public static boolean isAvailable(boolean[] arr, int start, int end) {
        if (start > 0 && arr[start-1] && end < 1440 && arr[end+1]) {
            return false;
        }
        if (start == 0 && arr[start] && end < 1440 && arr[end+1]) {
            return false;
        }
        if (start > 0 && arr[start-1] && end == 1440 && arr[end]) {
            return false;
        }
        if (start == 0 && arr[start] && end == 1440 && arr[end]) {
            return false;
        }


        boolean startOrg = arr[start];
        boolean endOrg = arr[end];
        arr[start] = false;
        arr[end] = false;

        for (int i = start; i <= end; i++) {
            if (arr[i]) {
                arr[start] = startOrg;
                arr[end] = endOrg;
                return false;
            }
        }

        arr[start] = startOrg;
        arr[end] = endOrg;
        return true;
    }

    public static void fill(boolean[] arr, int start, int end) {
        for (int i = start; i <= end; i++) {
            arr[i] = true;
        }
    }
}
