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

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            short testCases = Short.parseShort(scanner.nextLine());

            for (int i = 0; i < testCases; i++) {
                short numPairs = Short.parseShort(scanner.nextLine());
                List<Pair> pairs = new ArrayList<>();

                for (int j = 0; j < numPairs; j++) {
                    String[] times = scanner.nextLine().split(" ");
                    int start = Integer.parseInt(times[0]);
                    int end = Integer.parseInt(times[1]);
                    pairs.add(new Pair(start, end));
                }

                pairs.sort((p1, p2) -> Integer.compare(p1.start, p2.start));
                String result = assignSchedules(pairs);
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
    }

    private static String assignSchedules(List<Pair> pairs) {
        StringBuilder schedule = new StringBuilder();
        Pair j = null;
        Pair c = null;

        for (Pair pair : pairs) {
            if (j == null) {
                j = pair;
                schedule.append("J");
            } else if (c == null) {
                c = pair;
                schedule.append("C");
            } else if (j.end <= pair.start) {
                j = pair;
                schedule.append("J");
            } else if (c.end <= pair.start) {
                c = pair;
                schedule.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }
}