import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileReader("src/matrix.txt"));
        int T = Integer.parseInt(sc.next());
        for(int t = 0; t < T; ++t) {
            int size = Integer.parseInt(sc.next());
            int[][] mat = new int[size][size];
            int trace = 0;
            for(int i =0; i < size; ++i) {
                for(int j = 0; j < size; ++j) {
                    mat[i][j] = Integer.parseInt(sc.next());
                    if(i == j) trace += mat[i][j];
                }
            }
            findLatin(mat, size, t+1, trace);
        }
    }

    private static void findLatin(int[][] mat, int size, int test, int trace) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        int row = 0;
        int col = 0;
        for(int i =0; i < size; ++i) {
            rowSet = new HashSet<>();
            for(int j = 0; j < size; ++j) {
                if (rowSet.contains(mat[i][j])) {
                    row++;
                    break;
                }
                else {
                    rowSet.add(mat[i][j]);
                }
            }
        }
        for(int i =0; i < size; ++i) {
            colSet = new HashSet<>();
            for(int j = 0; j < size; ++j) {
                if(colSet.contains(mat[j][i])) {
                    col++;
                    break;
                } else {
                    colSet.add(mat[j][i]);
                }

            }
        }

        System.out.println("Case #" + test +": " + trace + " " + row + " " + col);
    }
}
