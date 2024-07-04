
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
        int index;

    }

    public static void main(String[] args) throws IOException {
        Scanner myReader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = Integer.parseInt(myReader.nextLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(myReader.nextLine());
            List<Pair> pairs = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                String[] min = myReader.nextLine().split(" ");
                Pair pair = new Pair();
                pair.start = Integer.parseInt(min[0]);
                pair.end = Integer.parseInt(min[1]);
                pair.index = j;
                pairs.add(pair);
            }

            pairs.sort(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o1.start - o2.start;
                }
            });
            String res = schedule(pairs);
            System.out.println("Case #" + (i + 1) + ": " + res);
        }

        myReader.close();
    }

    private static String schedule(List<Pair> pairs) {
        Pair j = null;
        Pair c = null;

        char[] res = new char[pairs.size()];
        for (Pair pair : pairs) {
            if (j == null) {
                j = pair;
                res[pair.index] = 'J';
                continue;
            }
            if (c == null) {
                c = pair;
                res[pair.index] = 'C';
                continue;
            }
            if (c.end <= pair.start && j.end <= pair.start) {
                c = pair;
                res[pair.index] = 'C';
                continue;
            }
            if (j.end <= pair.start) {
                j = pair;
                res[pair.index] = 'J';
                continue;
            }
            if (c.end <= pair.start) {
                c = pair;
                res[pair.index] = 'C';
                continue;
            }
            return "IMPOSSIBLE";

        }
        String ressult = "";
        for (int i = 0; i < pairs.size(); i++) {
            ressult += res[i];
        }
        return ressult;
    }


}
