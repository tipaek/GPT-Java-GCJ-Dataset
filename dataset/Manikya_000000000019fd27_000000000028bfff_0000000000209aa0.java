import java.util.*;
import java.io.*;
public class Solution {
    public static ArrayList<ArrayList<Integer> > diagonals;
    public static void findDiagonals(int n, int k, ArrayList<Integer> aux) {
        if(aux.size() == n) {
            if(k == 0) {
                diagonals.add(new ArrayList<>(aux));
            }
            return;
        }
        if(aux.size() >= n)
            return;
        for(int i = 1; i <= Math.min(n, k); i++) {
            aux.add(i);
            findDiagonals(n, k-i, aux);
            aux.remove(aux.size()-1);
        }
    }

    public static boolean findTrace(int[][] matrix, HashMap<Integer, HashSet<Integer>> row, HashMap<Integer, HashSet<Integer>> col, int i, int j) {
        if(i == matrix.length)
            return true;
        if(j >= matrix.length)
            return findTrace(matrix, row, col, i+1, 0);
        if(matrix[i][j] != 0)
            return findTrace(matrix, row, col, i, j+1);

        for(int val = 1; val <= matrix.length; val++) {
            if(row.get(i).contains(val) || col.get(j).contains(val))
                continue;
            row.get(i).add(val);
            col.get(j).add(val);
            boolean p = findTrace(matrix, row, col, i, j+1);
            if(p)
                return true;
            row.get(i).remove(val);
            col.get(j).remove(val);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int l = 1; l <= t; ++l) {
            int n = in.nextInt();
            int k = in.nextInt();
            diagonals = new ArrayList<>();
            findDiagonals(n, k, new ArrayList<>());
            boolean possible = false;

            for(int i = 0; i < diagonals.size(); i++) {
                HashMap<Integer, HashSet<Integer>> row = new HashMap<>();
                HashMap<Integer, HashSet<Integer>> col = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    row.put(j, new HashSet<>());
                    col.put(j, new HashSet<>());
                }
                int[][] matrix = new int[n][n];
                for(int j = 0; j < diagonals.get(i).size(); j++) {
                    matrix[j][j] = diagonals.get(i).get(j);
                    row.get(j).add(diagonals.get(i).get(j));
                    col.get(j).add(diagonals.get(i).get(j));
                }
                possible = findTrace(matrix, row, col, 0, 0);
                if(possible)
                    break;
            }
            System.out.println("Case #" + l + ": " + (possible ? "POSSIBLE": "IMPOSSIBLE"));
        }
    }
}