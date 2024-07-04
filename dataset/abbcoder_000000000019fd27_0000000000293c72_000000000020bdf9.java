import java.util.*;

public class Solution {

    public static void main(String[] args) {
        ArrayList<int[][]> cases = readLines();

        for (int c = 1; c <= cases.size(); c++) {
            int[][] lines = cases.get(c - 1);

            int N = lines[0][0];

            ArrayList<int[]> times = new ArrayList<>(N);
            for (int i = 0; i < N; i++) {
                int[] se = lines[i + 1];
                times.add(new int[]{se[0], se[1], i});
            }
            times.sort(Comparator.comparingInt(a -> a[0]));

            int time1 = 0;
            int time2 = 0;
            boolean possible = true;
            char[] order = new char[N];

            for (int[] se : times) {
                int start = se[0];
                int end = se[1];
                int index = se[2];

                if (time1 < time2) {
                    if (time1 <= start) {
                        time1 = end;
                        order[index] = 'C';
                    } else if (time2 <= start) {
                        time2 = end;
                        order[index] = 'J';
                    } else {
                        possible = false;
                    }
                } else {
                    if (time2 <= start) {
                        time2 = end;
                        order[index] = 'J';
                    } else if (time1 <= start) {
                        time1 = end;
                        order[index] = 'C';
                    } else {
                        possible = false;
                    }
                }
            }
            String result = possible ? new String(order) : "IMPOSSIBLE";
            print(String.format("Case #%d: %s", c, result));
        }
    }

    static ArrayList<int[][]> readLines() {
        Scanner in = new Scanner(System.in);

        int T = Integer.parseInt(in.nextLine());
        ArrayList<int[][]> cases = new ArrayList<>(T);

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(in.nextLine());
            int[][] lines = new int[N + 1][];
            cases.add(lines);

            lines[0] = new int[]{N};
            for (int n = 0; n < N; n++) {
                lines[n + 1] = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        }

        in.close();
        return cases;
    }

    static void print(String line) {
        System.out.println(line);
    }
}
