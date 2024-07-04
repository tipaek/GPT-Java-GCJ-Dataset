import java.util.*;

public class Solution {

    public static class Result {
        public int k, r, c;

        public Result(int k, int r, int c) {
            this.k = k;
            this.r = r;
            this.c = c;
        }
    }

    public static Result checkLatin(List<List<Integer>> matrix) {
        int n = matrix.size();
        int k = 0, r = 0, c = 0;

        for (int i = 0; i < n; i++) {
            k += matrix.get(i).get(i);
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix.get(i).get(j))) {
                    r++;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (!colSet.add(matrix.get(j).get(i))) {
                    c++;
                    break;
                }
            }
        }

        return new Result(k, r, c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            List<List<Integer>> matrix = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(sc.nextInt());
                }
                matrix.add(row);
            }

            Result res = checkLatin(matrix);
            System.out.println("Case #" + t + ": " + res.k + " " + res.r + " " + res.c);
        }
    }
}