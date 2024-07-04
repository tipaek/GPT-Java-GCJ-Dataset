import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int runs = in.nextInt();
        int reps = 0;
        
        while(runs - 1 >= reps) {
            int diag = 0;
            int rowRep = 0;
            int colRep = 0;
            
            int size = in.nextInt();
            int[][] arr2d = new int[size][size];
            
            //pop a 2d array
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    arr2d[i][j] = Integer.parseInt(in.next());
                }
            }
            
            //O(n^2)
            for (int i = 0; i < size; i++) {
                HashSet<Integer> Rset = new HashSet<Integer>();
                HashSet<Integer> Cset = new HashSet<Integer>();
                boolean rowSet = true;
                boolean colSet = true;

                for (int j = 0; j < size; j++) {
                    if (i == j) {
                        diag += arr2d[i][j];
                    }
                    if (Rset.add(arr2d[i][j]) == false && rowSet == true) {
                        rowRep++;
                        rowSet = false;
                    }
                    if (Cset.add(arr2d[j][i]) == false && colSet == true) {
                        colRep++;
                        colSet = false;
                    }
                }
            }
            reps++;
            System.out.println("Case #" + reps +": " + diag + " " + rowRep + " " + colRep);
        }
    }
}