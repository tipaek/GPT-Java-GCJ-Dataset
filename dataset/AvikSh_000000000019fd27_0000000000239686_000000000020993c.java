import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args){
        int t, n;
        int[][] mat;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        t = in.nextInt();
        for(int i=0; i<t; i++){
            n = in.nextInt();
            mat = new int[n][n];
            for(int r=0; r<n; r++){
                for(int c=0; c<n; c++){
                    mat[r][c] = in.nextInt();
                }
            }
            int trace = 0;
            int cols = 0;
            int rows = 0;

            for(int j=0; j<n; j++){
                trace+= mat[j][j];
            }

            Set<Integer> setRow;
            Set<Integer> setCol;
            for(int row=0; row<n; row++){
                setRow = new HashSet<>();
                setCol = new HashSet<>();
                boolean dupRowFound = false;
                boolean dupColFound = false;
                for(int col=0; col<n; col++){
                    if(!dupRowFound && setRow.contains(mat[row][col])){
                        rows++;
                        dupRowFound = true;
                    } else {
                        setRow.add(mat[row][col]);
                    }

                    if(!dupColFound && setCol.contains(mat[col][row])){
                        cols++;
                        dupColFound = true;
                    } else {
                        setCol.add(mat[col][row]);
                    }
                }
            }
            int caseNo = i+1;
            System.out.println("Case #" + caseNo + ": " + trace + " " + rows + " " + cols);
        }
    }
}
