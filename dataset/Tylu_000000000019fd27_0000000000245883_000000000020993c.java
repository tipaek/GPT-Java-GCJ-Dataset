
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int ca = 1; ca <= t; ++ca) {
            int n = in.nextInt();
            int k = 0;
            int r = 0;
            int c = 0;

            List<List<Integer>> cols = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                cols.add(new ArrayList<>());
            }

            for (int i = 0; i < n; ++i) {
                List<Integer> row = new ArrayList<>();

                for (int j = 0; j < n; ++j) {
                    int l = in.nextInt();
                    row.add(l);
                    if (i == j) {
                        k += l;
                    }
                    cols.get(j).add(l);
                }
                if (!allDifferent(row)) r++;
            }
            c = cols.stream().map(Solution::allDifferent).mapToInt(x -> x ? 0 : 1).sum();

            System.out.println("Case #" + ca + ": " + k + " " + r + " " + c);
        }
    }

    public static boolean allDifferent(List<Integer> list) {
        Set<Integer> set = new HashSet<Integer>(list);
        return set.size() == list.size();
    }
}
  