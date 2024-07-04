import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        int t=scanner.nextInt();
        for(int T=1;T<=t;T++){
            int n=scanner.nextInt();
            int[][] mat=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    mat[i][j]=scanner.nextInt();
                }
            }
            int trace=0;
            int i=0;
            int j=0;
            while(i<n&&j<n){
                trace+=mat[i][j];
                i++;
                j++;
            }
            
            int row=0;
            for(i=0;i<n;i++){
                HashSet<Integer> hs=new HashSet<Integer>();
                for(j=0;j<n;j++){
                    hs.add(mat[i][j]);
                }
                if(hs.size()!=n)row++;
            }
            int col=0;
             for(i=0;i<n;i++){
                HashSet<Integer> hs=new HashSet<Integer>();
                for(j=0;j<n;j++){
                    hs.add(mat[j][i]);
                }
                if(hs.size()!=n)col++;
            }
            System.out.println("Case #"+T+": "+ trace+" "+row+" "+col);
        }
    }
}