import java.util.*;
import java.io.*;

class Solution{
    public static void main(String args[])throws IOException{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int c = 0;
        while(t--!=0){
            int n = sc.nextInt();
            int mat[][] = new int[n][n];
            int trace = 0;
            int nRows = 0, nCols = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    mat[i][j] = sc.nextInt();
                    if(i==j)
                        trace+=mat[i][j];
                }
            }
            for(int i=0;i<n;i++){
                boolean arc[] = new boolean[n];
                for(int j=0;j<n;j++){
                    if(arc[mat[j][i]-1]==true){
                        nCols++;
                        break;
                    }
                    else{
                        arc[mat[j][i]-1] = true;
                    }
                }
            }
            for(int i=0;i<n;i++){
                boolean arr[] = new boolean[n];
                for(int j=0;j<n;j++){
                    if(arr[mat[i][j]-1]==true){
                        nRows++;
                        break;
                    }
                    else{
                        arr[mat[i][j]-1] = true;
                    }
                }
            }
            System.out.println("Case #"+(++c)+": "+trace+" "+nRows+" "+nCols);
        }
    }
}