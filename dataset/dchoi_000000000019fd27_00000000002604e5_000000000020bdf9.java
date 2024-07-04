import java.io.*;
import java.util.*;

public class Solution {

    public static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            List<Pair> cameron = new ArrayList<>();
            List<Pair> jamie = new ArrayList<>();
            String result = "";

            for (int n = 1; n <= N; n++) {
                int startTime = sc.nextInt();
                int endTime = sc.nextInt();

                if (result.equals("IMPOSSIBLE")) {
                    continue;
                }

                int isAvailableC = isAvailable(cameron, startTime, endTime);
                int isAvailableJ = isAvailable(jamie, startTime, endTime);

                if (isAvailableC >= 0) {
                    result += "C";
                    cameron.add(isAvailableC, new Pair(startTime, endTime));
                }
                else if (isAvailableJ >= 0) {
                    result += "J";
                    jamie.add(isAvailableJ, new Pair(startTime, endTime));
                }
                else {
                    result = "IMPOSSIBLE";
                }
            }

            String line = "Case #" + test_case + ": " + result;
            System.out.println(line);
        }
    }

    public static int isAvailable(List<Pair> arr, int start, int end) {
        if (arr.size() <= 0) {
            return 0;
        }

        for (int i = 0; i < arr.size(); i++) {
            Pair p = arr.get(i);


            if (i == 0 && end <= p.start) {
                return i;
            }


            if (i == arr.size() - 1 && start >= p.end) {
                return i + 1;
            }

            if (i > 0 && i < arr.size() - 1) {
                Pair prev = arr.get(i - 1);
                Pair next = arr.get(i + 1);
                if (start >= prev.end && end <= next.start) {
                    return i + 1;
                }
            }
        }

        return -1;
    }
}
