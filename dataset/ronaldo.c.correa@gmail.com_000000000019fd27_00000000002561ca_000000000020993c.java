import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int iT = 1; iT <= T; iT++) {
            int N = scanner.nextInt();

            Map<Integer, Set<Integer>> colControl = new HashMap<>();
            Map<Integer, Set<Integer>> rowControl = new HashMap<>();
            long [] ans = new long[3];
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    Integer cell = scanner.nextInt();
                    ans[0] += row == col ? cell : 0;

                    if (!colControl.containsKey(col)) {
                        colControl.put(col, new HashSet<>());
                    }
                    colControl.get(col).add(cell);

                    if (!rowControl.containsKey(row)) {
                        rowControl.put(row, new HashSet<>());
                    }
                    rowControl.get(row).add(cell);
                }
            }
            ans[1] = rowControl.values()
                    .stream().filter(integers -> integers.size() < N).count();
            ans[2] = colControl.values()
                    .stream().filter(integers -> integers.size() < N).count();
            System.out.println(String.format("Case #%d: %d %d %d",iT,ans[0], ans[1], ans[2]));
        }
        scanner.close();
    }
}
