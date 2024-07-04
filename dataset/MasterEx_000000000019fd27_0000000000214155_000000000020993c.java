
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Periklis Ntanasis <pntanasis@gmail.com>
 */
public class Solution {

    static class Case {

        public int N;
        public int rowTotal = 0;
        public short[][] matrix;
    }

    public static void main(String[] args) {
        List<Case> cases = readCases();
        int i = 1;
        for (Case c : cases) {
            int[] dups = calculateDuplicateRowsAndColumns(c);
            System.out.println("Case #" + (i++) + ": " + calculateTrace(c) + " " + dups[0] + " " + dups[1]);
        }
    }

    static List<Case> readCases() {
        List<Case> cases = new ArrayList<>();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            Case c = new Case();
            c.N = in.nextInt();
            c.matrix = new short[c.N][c.N];
            for (int r = 0; r < c.N; r++) {
                for (int col = 0; col < c.N; col++) {
                    c.matrix[r][col] = in.nextShort();
                }
            }
            for (int n = 1; n <= c.N; n++) {
                c.rowTotal += n;
            }
            cases.add(c);
        }
        return cases;
    }

    static int calculateTrace(Case c) {
        int trace = 0;
        for (int i = 0; i < c.N; i++) {
            trace += c.matrix[i][i];
        }
        return trace;
    }

    static int[] calculateDuplicateRowsAndColumns(Case c) {
        int dupRow = 0, dupCol = 0;
        Set<Short> rows = new HashSet<>();
        Set<Short> cols = new HashSet<>();
        for (int i = 0; i < c.N; i++) {
//            int sumRow = 0, sumCol = 0;
            rows.clear();
            cols.clear();
            for (int j = 0; j < c.N; j++) {
                rows.add(c.matrix[i][j]);
                cols.add(c.matrix[j][i]);
//                sumRow += c.matrix[i][j];
//                sumCol += c.matrix[j][i];
            }
//            dupRow += sumRow == c.rowTotal ? 0 : 1;
//            dupCol += sumCol == c.rowTotal ? 0 : 1;
                dupRow += rows.size() == c.N ? 0 : 1;
                dupCol += cols.size() == c.N ? 0 : 1;
            }
            return new int[]{dupRow, dupCol};
        }

    }
