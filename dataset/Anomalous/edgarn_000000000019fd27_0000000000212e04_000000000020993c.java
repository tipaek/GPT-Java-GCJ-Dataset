import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();

        for (int test = 1; test <= tests; test++) {
            int size = sc.nextInt();
            ArrayList<HashSet<Integer>> cols = new ArrayList<>();
            HashSet<Integer> row = new HashSet<>();

            int rowrep = 0;
            int colrep = 0;
            int diag = 0;
            int diagonalval = 0;

            int seenrow = 0;
            HashSet<Integer> seencols = new HashSet<>();

            for (int i = 0; i < size * size; i++) {
                int curr = sc.nextInt();

                if (i == diagonalval) {
                    diag += curr;
                    diagonalval += size + 1;
                }

                if (i % size == 0) {
                    row = new HashSet<>();
                    seenrow = 0;
                }

                if (i < size) {
                    cols.add(new HashSet<>());
                }

                if (row.contains(curr) && seenrow == 0) {
                    rowrep++;
                    seenrow = 1;
                }

                if (cols.get(i % size).contains(curr) && !seencols.contains(i % size)) {
                    colrep++;
                    seencols.add(i % size);
                }

                row.add(curr);
                cols.get(i % size).add(curr);
            }

            System.out.println("Case #" + test + ": " + diag + " " + rowrep + " " + colrep);
        }

        sc.close();
    }
}