import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int T = sc.nextInt();
        for (int tt = 1; tt <= T; tt++) {
            int n = sc.nextInt();
            sc.nextLine();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String[] row = sc.nextLine().split(" ");
                arr[i][0] = Integer.parseInt(row[0]);
                arr[i][1] = Integer.parseInt(row[1]);
            }
            
            Arrays.sort(arr, (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                } else {
                    return Integer.compare(a[0], b[0]);
                }
            });

            List<int[]> c = new ArrayList<>();
            List<int[]> j = new ArrayList<>();
            StringBuilder sb = new StringBuilder(" ".repeat(n));
            c.add(arr[0]);
            sb.setCharAt(0, 'C');
            boolean possible = true;
            Map<int[], Integer> indexMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                indexMap.put(arr[i], i);
            }

            for (int i = 1; i < n; i++) {
                if (arr[i][0] >= c.get(c.size() - 1)[1]) {
                    c.add(arr[i]);
                    sb.setCharAt(indexMap.get(arr[i]), 'C');
                } else if (j.isEmpty() || arr[i][0] >= j.get(j.size() - 1)[1]) {
                    j.add(arr[i]);
                    sb.setCharAt(indexMap.get(arr[i]), 'J');
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                out.println("Case #" + tt + ": IMPOSSIBLE");
            } else {
                out.println("Case #" + tt + ": " + sb.toString());
            }
        }
        out.flush();
    }
}