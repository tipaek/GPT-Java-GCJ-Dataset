import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int k = 0, r = 0, c = 0;

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int x = 0; x < t; x++) {
            int order = sc.nextInt();

            Set<Integer> row = new HashSet<>();
            List<Set<Integer>> col = initializeCol(order);

            for (int i=0; i<order; i++) {
                for (int j=0; j<order; j++) {
                    int val = sc.nextInt();
                    row.add(val);
                    k += (i == j) ? val : 0;

                    col.get(j).add(val);
                }

                r += (order - row.size()) == 0 ? 0 : 1;
            }

            for (Set<Integer> vish : col) {
                c += (order - vish.size()) == 0 ? 0 : 1;
            }

            String output = String.format("Case #%d: %d %d %d", x, k, r, c);
            System.out.println(output);

            k = 0;
            r = 0;
            c = 0;
        }
    }

    private static List<Set<Integer>> initializeCol(int order) {
        List<Set<Integer>> eita = new ArrayList<>();
        for (int i=0; i<order; i++) {
            eita.add(new HashSet<>());
        }
        return eita;
    }

    private static int sum(int n) {
        int r = 0;
        for (int i=0; i<n; i++) { r += i; }
        return r;
    }
}
