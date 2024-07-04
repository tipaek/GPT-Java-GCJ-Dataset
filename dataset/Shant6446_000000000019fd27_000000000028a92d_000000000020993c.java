import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {

        List<HashMap<Integer, Integer>> listHashMap = new ArrayList<>();

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int i = 1; i <= T; ++i) {

            int repeatRows = 0, repeatCols = 0;
            int trace = 0;

            int N = in.nextInt();
            int[][] M = new int[N][N];

            for (int j = 0; j < N; j++) {

                HashSet<Integer> uniques = new HashSet<>();

                for (int k = 0; k < N; k++) {

                    int element = Integer.parseInt(in.next());
                    if (j == k) {
                        trace = trace + element;
                    }
                    M[j][k] = element;
                    uniques.add(element);
                }

                if (uniques.size() < N) {
                    repeatRows++;
                }
            }

            for (int j = 0; j < N; j++) {

                HashSet<Integer> uniques = new HashSet<>();

                for (int k = 0; k < N; k++) {
                    uniques.add(M[k][j]);
                }

                if (uniques.size() < N) {
                    repeatCols++;
                }
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, trace);
            map.put(1, repeatRows);
            map.put(2, repeatCols);
            listHashMap.add(map);
        }

        for (int i = 0; i < listHashMap.size(); i++) {
            System.out.println(String.format("Case #%d: %d %d %d", i + 1, listHashMap.get(i).get(0), listHashMap.get(i).get(1), listHashMap.get(i).get(2)));
        }
    }
}