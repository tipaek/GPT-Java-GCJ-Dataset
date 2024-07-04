import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class Pair {
        int start;
        int end;
        int index;

        Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(scanner.nextLine());
            List<Pair> pairs = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                String[] times = scanner.nextLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                pairs.add(new Pair(start, end, j));
            }

            pairs.sort((o1, o2) -> Integer.compare(o1.start, o2.start));
            String result = schedule(pairs);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }

        scanner.close();
    }

    private static String schedule(List<Pair> pairs) {
        Pair j = null;
        Pair c = null;

        char[] res = new char[pairs.size()];
        for (Pair pair : pairs) {
            if (j == null) {
                j = pair;
                res[pair.index] = 'J';
            } else if (c == null) {
                c = pair;
                res[pair.index] = 'C';
            } else if (j.end <= pair.start) {
                j = pair;
                res[pair.index] = 'J';
            } else if (c.end <= pair.start) {
                c = pair;
                res[pair.index] = 'C';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(res);
    }
}