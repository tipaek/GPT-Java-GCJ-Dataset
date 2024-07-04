

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author DPC
 */
public class Solution {
    
    
    public static void main(String a[]) throws IOException{
        
        doIt();
    }

    private static void doIt() throws IOException {
        BufferedReader in = new BufferedReader( new  InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(in.readLine());
        int nTc = Integer.parseInt(stk.nextToken());
        for(int tc=1;tc<=nTc;tc++){
            executeOneTc(tc,in);
        }
    }
    
    

    private static void executeOneTc(int caseNo,BufferedReader in) throws IOException {
        
        StringTokenizer stk = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int trace = Integer.parseInt(stk.nextToken());
        int mat[][] = new int[n][n];
        if(n>6){
            throw new RuntimeException("Big N");
        }
        boolean rslt = doItRecursive(n,mat,0,0,new boolean[n][n+1],new boolean[n][n+1],trace);
        if(!rslt){
                    System.out.println("Case #"+caseNo+": IMPOSSIBLE");

        } else{
                    System.out.println("Case #"+caseNo+": POSSIBLE");
                    
                    for(int r=0;r<n;r++){
                        for(int c=0;c<n;c++){
                            System.out.print(mat[r][c]+" ");
                        }
                        System.out.println();
                    }
            
        }
    }
    
    
    private static long computeTrace(int mat[][]){
        int n = mat.length;
        long trace = 0;
        for(int i=0;i<n;i++){
            trace+= mat[i][i];
        }
        
        return trace;
    }

    private static boolean doItRecursive(int n, int[][] mat, int rowNum, int colNum, boolean[][] rowFlags, boolean[][] colFlags, long trace) {
       if(rowNum == n){
           if(computeTrace(mat) == trace){
            return true;
           } else{
               return false;
           }
       }
       
        for(int val=1;val<=n;val++){
            if(!rowFlags[rowNum][val] && !colFlags[colNum][val]){
                rowFlags[rowNum][val] = true;
                colFlags[colNum][val] = true;
                mat[rowNum][colNum] = val;
                boolean rslt = false;
                if(colNum<n-1){
                    rslt = doItRecursive(n, mat, rowNum, colNum+1, rowFlags, colFlags, trace);
                } else{
                    rslt = doItRecursive(n, mat, rowNum+1, 0, rowFlags, colFlags, trace);
                }
                
                if(rslt){
                    return true;
                }
                rowFlags[rowNum][val] = false;
                colFlags[colNum][val] = false;
                
            }
        }
        
        return false;
    }
    
    
}
