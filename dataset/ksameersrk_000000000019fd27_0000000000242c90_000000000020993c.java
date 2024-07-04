import java.util.*;

public class Solution {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int trace = 0;
            boolean[] rowCountArray = new boolean[N];
            boolean[] colCountArray = new boolean[N];
            List<Set<Integer>> rowSets = new ArrayList<>();
            List<Set<Integer>> colSets = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                rowSets.add(new HashSet<>());
                colSets.add(new HashSet<>());
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int tmp = in.nextInt();
                    if (i == j) trace += tmp;
                    if (rowSets.get(i).contains(tmp)) rowCountArray[i] = true;
                    else rowSets.get(i).add(tmp);
                    if (colSets.get(j).contains(tmp)) colCountArray[j] = true;
                    else colSets.get(j).add(tmp);
                }
            }
            int rowCount = 0;
            int colCount = 0;
            for (int i = 0; i < N; i++) {
                if (rowCountArray[i]) rowCount++;
                if (colCountArray[i]) colCount++;
            }
            System.out.println(String.format("Case #%d: %d %d %d", t, trace, rowCount, colCount));
        }
    }
}
