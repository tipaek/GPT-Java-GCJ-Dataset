import java.util.*;
import java.io.*;

class Solution{
    public static void main(String args[]){
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=0;t<T;t++){
            int n = in.nextInt();
            int a[][] = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j] = in.nextInt();    
                }
            }
            System.out.println("Case #" + (t+1) + ":" + diagSum(a,n) + " " + rowRep(a,n) + " " + colRep(a,n));
        }
    }
    
    public static int diagSum(int a[][], int n){
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=a[i][i];
        }
        return sum;
    }
    
    public static int rowRep(int a[][], int n){
        int maxRep = 0;
        for(int row=0;row<n;row++){
            for(int i=0;i<n;i++){
                int rowCnt = 0;
                for(int j=0;j<n;j++){
                    if(a[row][i] == a[row][j]){
                        rowCnt++;
                    }
                }
                if(rowCnt>maxRep){
                    maxRep = rowCnt;
                }
            }
        }
        if(maxRep == 1){
            maxRep = 0;
        }
        return maxRep;
    }
    
    public static int colRep(int a[][], int n){
        int maxCol = 0;
        for(int col=0;col<n;col++){
            for(int i=0;i<n;i++){
                int colCnt = 0;
                for(int j=0;j<n;j++){
                    if(a[i][col] == a[j][col]){
                        colCnt++;
                    }
                }
                if(colCnt>maxCol){
                    maxCol = colCnt;
                }
            }
        }
        if(maxCol == 1){
            maxCol = 0;
        }
        return maxCol;
    }
}