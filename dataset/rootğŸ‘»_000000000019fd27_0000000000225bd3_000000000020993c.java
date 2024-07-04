import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        for (int test = 1; test <= tests; ++test) {
            int t = in.nextInt();
            List<Set<Integer>> verticals = new ArrayList<>(t);
            int xRepeat = 0;
            int yRepeat = 0;
            int trace = 0;
            for (int i = 0; i < t; ++i) {
                Set<Integer> horizontal = new HashSet<>(t);
                for (int j = 0; j < t; ++j) {
                    int n = in.nextInt();
                    if (i == 0) {
                        verticals.add(new HashSet<>(t));
                    }
                    horizontal.add(n);
                    verticals.get(i).add(n);
                    if (i == t) {
                        yRepeat += t - verticals.get(i).size();
                    }
                    if (i == j) {
                        trace += n;
                    }
                }
                xRepeat += t - horizontal.size();
            }
            System.out.printf("Case #%d: %d %d %d", test, trace, xRepeat, yRepeat);
        }
    }
}