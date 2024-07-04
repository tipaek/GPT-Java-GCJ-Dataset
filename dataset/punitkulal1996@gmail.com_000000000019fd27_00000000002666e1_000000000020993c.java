import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int N = s.nextInt();
            List<Set<Integer>> columns = new ArrayList<>(N);
            List<Set<Integer>> rows = new ArrayList<>(N);
            int trace = 0;
            Set<Integer> dc = new HashSet<>();
            Set<Integer> dr = new HashSet<>();
            for (int j = 0; j < N; j++) {
                columns.add(j, new HashSet<>());
                rows.add(j, new HashSet<>());
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int v = s.nextInt();
                    if (rows.get(j).contains(v)){
                        dr.add(j);
                    }
                    if (columns.get(k).contains(v)){
                        dc.add(k);
                    }
                    if (j == k){
                        trace += v;
                    }
                    rows.get(j).add(v);
                    columns.get(k).add(v);
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + dr.size() + " " + dc.size());

        }
    }
}
