import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        int tc=scan.nextInt();
        int iter=0;
        while(iter<tc){
            int n=scan.nextInt();
            int mat[][]=new int[n][n];
            for(int i=0;i<n;++i){
                for(int j=0;j<n;++j){
                    mat[i][j]=scan.nextInt();
                }
            }
            
            int i=0,j=0,trace=0,numRows=0,numCols=0;
            while(i<n){
                trace+=mat[i++][j++];
            }
            
            
            for(i=0;i<n;++i){
                int counterR=1,counterC=1;
                int arr1[]=new int[n];
                int arr2[]=new int[n];
                for(j=0;j<n;++j){
                    if(counterR==1){
                        if(arr1[mat[i][j]-1]==1){
                            numRows++;
                            counterR=0;
                        }
                        arr1[mat[i][j]-1]=1;
                    }
                    if(counterC==1){
                        if(arr2[mat[j][i]-1]==1){
                            numCols++;
                            counterC=0;
                        }
                        arr2[mat[j][i]-1]=1;
                    }
                }
            }
            
            System.out.printf("Case #%d: %d %d %d\n",iter+1,trace,numRows,numCols);
            iter++;
        }
        
    }
}