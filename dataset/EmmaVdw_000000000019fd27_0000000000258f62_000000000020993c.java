import java.util.*;
import java.io.*;

public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            in.nextLine();
            System.out.println(n);
            int[][] arr = new int[n][n];
            int trace=0;
            int index_trace=0;
            int r=0;
            int c=0;
            for (int j=0; j<(n-1)*(n-1); ++j){
                int y = in.nextInt();
                if (j==index_trace){
                    trace+=y;
                    index_trace+=(n+1);
                }
                arr[r][c]=y;
                System.out.println("row:"+r+" column:"+c);
                c+=1;
                if (j%n==0){
                    r+=1;
                    c=0;
                    if(in.hasNextLine()){
                        in.nextLine();
                    }
                }
            }
            int row=0;
            int column=0;
            boolean[][] rep = new boolean[2][n];
            for (int j=0; j<n; ++j){
                rep[0][j]=false;
                rep[1][j]=false;
            }
            for (int j=0; j<n; ++j){
                for (int k=0; k<n; ++k){
                    int check = arr[j][k];
                    for (int l=0; l<n; ++l){
                        if (check == arr[j][l] && k!=l && rep[0][j]==false){
                            row+=1;
                            rep[0][j]=true;
                        }
                        if (check == arr[l][k] && l!=j && rep[1][k]==false){
                            column+=1;
                            rep[1][k]=true;
                        }
                        if (rep[0][j] && rep[1][k]){
                            break;
                        }
                    }
                    if(row==n && column==n){
                        break;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + row + " " + column);
        }
    }
}