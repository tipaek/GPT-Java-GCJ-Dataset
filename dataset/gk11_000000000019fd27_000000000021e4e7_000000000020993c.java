import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for (int t=1; t<=T; t++) {
            doCase(scanner, t);
        }
    }

    public static void doCase(Scanner scanner, int t) {
        int N = scanner.nextInt();
        int sum = 0;
        int rowdup = 0;
        int coldup = 0;
        List<Set<Integer>> cols = new ArrayList<>(N);
        for (int j=0;j<N;j++) {
            Set<Integer> col = new HashSet<>();
            cols.add(col);
        }
        for (int i=0;i<N;i++) {
            Set<Integer> row = new HashSet<>();
            for (int j=0;j<N;j++) {
                int c = scanner.nextInt();
                sum += (i==j) ? c : 0;
                row.add(c);
                cols.get(j).add(c);
            }
            rowdup += (row.size() < N) ?1:0;
        }
        coldup = cols.stream().mapToInt(s -> s.size() < N?1:0).sum();
        System.out.println("Case #"+t+": "+sum+" "+rowdup+" "+coldup);
    }
}
