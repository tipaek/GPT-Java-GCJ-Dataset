import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,k,r,c;
        int t = Integer.parseInt(in.next());
        int count  = 0;

        while(t-->0){
            count++;
            n = Integer.parseInt(in.next());
            k=r=c=0;
            int[][] mat = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = Integer.parseInt(in.next());
                }
            }

            for (int i = 0,j = 0; i < n; i++,j++) {
                k += mat[i][j];
            }

            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(row.contains(mat[i][j])){
                        r++;
                        row.clear();
                        break;
                    }
                    else{
                        row.add(mat[i][j]);
                    }
                }
                row.clear();
            }

            ArrayList<Integer> col = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(col.contains(mat[j][i])){
                        c++;
                        col.clear();
                        break;
                    }
                    else{
                        col.add(mat[j][i]);
                    }
                }
                col.clear();
            }

            System.out.println("Case #"+count+": "+k+" "+r+" "+c);
        }
    }
}