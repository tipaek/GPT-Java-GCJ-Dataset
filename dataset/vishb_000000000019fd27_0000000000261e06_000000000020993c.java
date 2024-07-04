import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int _t=0; _t<t; _t++) {

            int n = sc.nextInt();

            List<List<Integer>> grid = new ArrayList<>(n);
            for (int i=0; i<n; i++) {
                List<Integer> iList = new ArrayList<>(n);
                for (int j=0; j<n; j++) {
                    iList.add(sc.nextInt());
                }
                grid.add(iList);
            }

            // check row
            int rowErrors = 0;
            for (int row=0; row<n; row++) {
                int isum = grid.get(row).stream().collect(Collectors.toSet()).size();
                if (isum != n) rowErrors++;
            }

            // check col
            int colErrors = 0;
            for (int col=0; col<n; col++) {
                Set<Integer> iset = new HashSet<>();
                for (int row=0; row<n; row++) {
                    iset.add(grid.get(row).get(col));
                }
                if (iset.size() != n) colErrors++;
            }

            int diag=0;
            for (int i=0; i<n; i++) {
                diag += grid.get(i).get(i);
            }

            System.out.printf("Case #%d: %d %d %d%n", _t+1, diag, rowErrors, colErrors);
        }
    }
}
