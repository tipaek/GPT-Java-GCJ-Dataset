import java.util.*;

class Vest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = Integer.parseInt(in.nextLine());
        while (tests-- > 0) {
            String line = in.nextLine();//line n
            int n = Integer.parseInt(line);
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                line = in.nextLine();
                String[] nums = line.split("\\s+");
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(nums[j]);
                }
            }
            solve(n, a);
        }
        in.close();
    }
    public static void solve(int n, int[][] a) {
        BitSet[] rows = new BitSet[n], cols = new BitSet[n];
        for (int i = 0; i < n; i++) {
            rows[i] = new BitSet(n+1);
            cols[i] = new BitSet(n+1);
        }
        int sum = 0, duprow = 0, dupcol = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                int num = a[i][j];
                if (i==j) sum += num;
                //System.out.println(n + " " + i + " " + j + " " + num + " " + rows[i].length());
                rows[i].set(num);
                cols[j].set(num);
            }
        }
        for (BitSet row : rows)
            if (row.cardinality()!=n) duprow++;
        for (BitSet col : cols)
            if (col.cardinality()!=n) dupcol++;
        System.out.println(sum + " " + duprow + " " + dupcol);
    }
}