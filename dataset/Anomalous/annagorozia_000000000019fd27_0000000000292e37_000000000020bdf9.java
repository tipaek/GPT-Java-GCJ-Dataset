import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
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
        try (Scanner myReader = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            short T = Short.parseShort(myReader.nextLine());
            for (int i = 0; i < T; i++) {
                short N = Short.parseShort(myReader.nextLine());
                List<Pair> pairs = new ArrayList<>();
                for (int j = 0; j < N; j++) {
                    String[] min = myReader.nextLine().split(" ");
                    int start = Integer.parseInt(min[0]);
                    int end = Integer.parseInt(min[1]);
                    pairs.add(new Pair(start, end));
                }
                pairs.sort(Comparator.comparingInt(o -> o.start));
                String res = schedule(pairs);
                System.out.println("Case #" + (i + 1) + ": " + res);
            }
        }
    }

    private static String schedule(List<Pair> pairs) {
        StringBuilder res = new StringBuilder();
        Pair j = null;
        Pair c = null;

        for (Pair pair : pairs) {
            if (j == null && c == null) {
                j = pair;
                res.append("J");
            } else if (j == null) {
                j = pair;
                res.append("J");
            } else if (c == null) {
                c = pair;
                res.append("C");
            } else if (c.end > pair.start && j.end <= pair.start) {
                j = pair;
                res.append("J");
            } else if (c.end <= pair.start && j.end > pair.start) {
                c = pair;
                res.append("C");
            } else if (c.end <= pair.start && j.end <= pair.start) {
                c = pair;
                res.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return res.toString();
    }
}