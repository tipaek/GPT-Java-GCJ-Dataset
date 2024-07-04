import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void solve(Scanner scanner, int tc) {
        int n = scanner.nextInt();
        int trace = 0;
        int row = 0;
        int column = 0;
        List<Set<Integer>> iList = new ArrayList<>();
        List<Set<Integer>> jList = new ArrayList<>();

        for(int i = 0 ; i < n; i++) {
            iList.add(new HashSet<>());
            jList.add(new HashSet<>());
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0 ; j < n; j++) {
                int matrixElement = scanner.nextInt();
                if(i == j) {
                    trace += matrixElement;
                }

                iList.get(i).add(matrixElement);
                jList.get(j).add(matrixElement);
            }
        }

        for(Set<Integer> is : iList) {
            if(is.size() != n)
                row++;
        }

        for(Set<Integer> js : jList) {
            if(js.size() != n)
                column++;
        }

        System.out.println(String.format("Case #%d: %d %d %d", tc, trace, row, column));
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tc = scanner.nextInt();
        for (int i = 0; i < tc; i++) {
            solve(scanner, i + 1);
        }
    }
}
