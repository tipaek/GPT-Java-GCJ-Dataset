import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int sum = n*(n+1)/2;
            int trace = 0;
            int rowflag = 0;
            int colflag = 0;
            int rowsum = 0;
            int colsum = 0;
            int[][] arr = new int[n][n];
            for(int j=0;j<n;j++){
                rowsum = 0;
                for(int k=0;k<n;k++){
                    arr[j][k] = sc.nextInt();
                    if(j == k)
                        trace += arr[j][k];
                    rowsum += arr[j][k];
                }
                if(rowsum != sum)
                    rowflag++;
            }
            for(int j=0;j<n;j++){
                colsum = 0;
                for(int k=0;k<n;k++){
                    colsum += arr[k][j];
                }
                if(colsum != sum)
                    colflag++;
            }
            System.out.println("Case #"+(i+1)+": "+n+" "+rowflag+" "+colflag);
        }
    }
}