import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.next());
        for(int t = 0; t < T; ++t) {
            int size = Integer.parseInt(sc.next());
            int[][] mat = new int[size][size];
            for(int i =0; i < size; ++i) {
                for(int j = 0; j < size; ++j) {
                    mat[i][j] = Integer.parseInt(sc.next());
                }
            }
            findLatin(mat, size, t+1);
        }
    }

    private static void findLatin(int[][] mat, int size, int test) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        int k = 0;
        int row = 0;
        int col = 0;
        for(int i =0; i < size; ++i) {
            rowSet = new HashSet<>();
            for(int j = 0; j < size; ++j) {
                if( i == j) k += mat[i][j];
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

        System.out.println("Case #" + test +": " + k + " " + rowSet.size() + " " + colSet.size());
    }
}
