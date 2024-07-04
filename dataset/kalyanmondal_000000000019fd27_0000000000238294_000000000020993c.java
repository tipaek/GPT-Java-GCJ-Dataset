import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))).useDelimiter("\n");
        String test = in.next();
        int t = Integer.parseInt(test);
        for (int i=0; i<t; i++) {
            String num = in.next();
            int n = Integer.parseInt(num);
            int k = 0;
            int r = 0;
            int c = 0;
            Integer matrix[][] = new Integer[n][n];
            for(int j=0; j<n; j++) {
                String matLine = in.next();
                String matLineArr[] = matLine.split(" ");
                for(int x=0; x<n; x++){
                    matrix[j][x] = Integer.parseInt(matLineArr[x]);
                }
                k+=Integer.parseInt(matLineArr[j]);
            }
            for (int x=0; x<n; x++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for(int y=0; y<n; y++) {
                    if(rowSet.contains(matrix[x][y])) {
                        r++;
                        break;
                    }
                    rowSet.add(matrix[x][y]);
                }
                for(int z=0; z<n; z++) {
                    if(colSet.contains(matrix[z][x])) {
                        c++;
                        break;
                    }
                    colSet.add(matrix[z][x]);
                }
            }
            System.out.println("Case #"+(i+1)+": "+k+" "+r+" "+c);
        }
        in.close();
    }
}
