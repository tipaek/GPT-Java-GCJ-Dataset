import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int c = 1; c <= t; c++) {
            int n = in.nextInt();
            int k = 0;
            List<Set<Integer>> rows = new ArrayList<>();
            List<Set<Integer>> cols = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                rows.add(new HashSet<>());
                cols.add(new HashSet<>());
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int d = in.nextInt();
                    rows.get(i).add(d);
                    cols.get(j).add(d);
                    if (i == j) k += d;
                }
            }
            int rowCount = 0;
            int colCount = 0;
            for (int i = 0; i < n; i++) {
                if (rows.get(i).size() < n) rowCount++;
                if (cols.get(i).size() < n) colCount++;
            }
            System.out.println(String.format("Case #%d: %d %d %d", c, k, rowCount, colCount));
        }
    }
}
