import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.lang.Integer;

public class Solution {
    public static void main(String[] arg){
        Scanner s=new Scanner(System.in);
        int tc=s.nextInt();
        for(int in=0;in<tc;in++){
            final int n=s.nextInt();
            int[][] arr=new int[n][n];
            int diagonalSum=0,rows=0,cols=0;
            Set<Integer> rowSet;
            Set<Integer> colSet;
            for(int i=0;i<n;i++) {
                rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    int num = s.nextInt();
                    rowSet.add(num);
                    arr[i][j]=num;
                    if (i == j) {
                        diagonalSum += num;
                    }
                }
                if (rowSet.size() != n) {
                    rows++;
                }
            }
            for(int i=0;i<n;i++){
                colSet= new HashSet<>();
                for(int j=0;j<n;j++){
                    colSet.add(arr[j][i]);
                }
                if(colSet.size()!=n){
                    cols++;
                }
            }
            System.out.println("Case #"+in+1+": "+diagonalSum+" "+rows+" "+cols);
        }
    }
}
