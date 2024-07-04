import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int k = 0; k < t; k++) {
            int n = input.nextInt();
            int trace = 0, col = 0, rows = 0;
            Set[] cols = new Set[n];
            for (int i = 0; i < n; i++)
                cols[i] = new HashSet();
            for (int i = 0; i < n; i++) {
                Set<Integer> Rows = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    int x = input.nextInt();
                    if (i == j) trace += x;
                    Rows.add(x);
                    cols[j].add(x);
                }
                if (Rows.size() != n) rows++;
            }
            for (int i = 0; i < n; i++)
                if (cols[i].size() != n) col++;
            System.out.println("Case #" + (k+1) + ": " + trace + " " + rows + " " + col);
        }
    }
}
