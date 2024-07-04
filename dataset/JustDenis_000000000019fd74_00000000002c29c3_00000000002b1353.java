import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public  static void  main(String[]  args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testNum = scanner.nextInt();
        for (int i = 0; i < testNum; i++)  {
            new Solution().solve(scanner, i);
        }
    }

    private void solve(Scanner scanner, int testNum) {
        int n = scanner.nextInt();

        Pascal p = new Pascal(10);

        dfs(1, 1, p, n, 0 , new ArrayList<>());

        System.out.println("Case #" + (testNum + 1) +  ":");
        for (Pair pe : fResult) {
            System.out.println(pe.getKey() + " " + pe.getValue());
        }
    }

    private boolean isFinished;
    private List<Pair> fResult = new ArrayList<>();
    private Set<Pair> visited = new HashSet<>();

    private void dfs(int r, int c, Pascal p, int n, int sum, List<Pair> result) {
        if (r < 1 || c > r || c < 1) {
            return;
        }
        Pair pair = new Pair(r, c);
        if (!visited.contains(pair)) {
            result.add(pair);
            visited.add(pair);

            if (sum <= n && result.size() <= 500 && !isFinished) {
                sum += p.getValue(r, c);
                if (n == sum) {
                    if (isFinished) {
                        return;
                    }
                    fResult = new ArrayList<>(result);
                    isFinished = true;
                }

                dfs(r - 1, c - 1, p, n, sum, result);
                dfs(r - 1, c, p, n, sum, result);
                dfs(r, c - 1, p, n, sum, result);
                dfs(r, c + 1, p, n, sum, result);
                dfs(r + 1, c, p, n, sum, result);
                dfs(r + 1, c + 1, p, n, sum, result);
            }

            result.remove(result.size() - 1);
            visited.remove(pair);
        }
    }

    class Pascal {
        List<List<Integer>> rows = new ArrayList<>();

        public Pascal(int iR) {
            for (int i = 0; i < iR; i++) {
                insertRow();
            }
        }

        public int getValue(int r, int c) {
            r--;
            c--;
            while (r >= rows.size()) {
                insertRow();
            }

            return rows.get(r).get(c);
        }

        private void insertRow() {
            rows.add(new ArrayList<>());
            int i = rows.size() - 1;
            List<Integer> col = rows.get(i);

            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    col.add(1);
                } else {
                    col.add(rows.get(i - 1).get(j - 1) + rows.get(i - 1).get(j));
                }
            }
        }
    }

    public class Pair {
        private int key;

        public int getKey() { return key; }

        private int value;

        public int getValue() { return value; }

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(key) + Integer.hashCode(value);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof Pair) {
                Pair pair = (Pair) o;
                if (this.key != pair.key) return false;
                if (this.value != pair.value) return false;
                return true;
            }
            return false;
        }
    }
}

