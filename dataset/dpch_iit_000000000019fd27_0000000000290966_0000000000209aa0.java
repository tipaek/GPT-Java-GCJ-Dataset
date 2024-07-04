

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
        
        List<ArrayList<Integer>> partitions = createPartitions(trace, n);

        int mat[][] = createInitialMat(n);
        
        for(ArrayList<Integer> diagonal : partitions){
        boolean rslt = tryDiagonal(n,mat,diagonal);
        
        if(rslt){
                    System.out.println("Case #"+caseNo+": POSSIBLE");
                    
                    for(int r=0;r<n;r++){
                        for(int c=0;c<n;c++){
                            System.out.print(mat[r][c]+" ");
                        }
                        System.out.println();
                    }
                    return;
        }
       }
        
                    System.out.println("Case #"+caseNo+": IMPOSSIBLE");
        
    }
    
    private static List<ArrayList<Integer>> createPartitions(int sum,int n){
        List<ArrayList<Integer>> rv = new ArrayList<ArrayList<Integer>>();
        createPartRecursive(sum,n,n,new ArrayList<Integer>(),rv);
        return rv;
    }
   
    private static long computeTrace(int mat[][]){
        int n = mat.length;
        long trace = 0;
        for(int i=0;i<n;i++){
            trace+= mat[i][i];
        }
        
        return trace;
    }

    private static void createPartRecursive(int sum, int maxN, int toSelect, ArrayList<Integer> curList, List<ArrayList<Integer>> rv) {
        
        if(maxN ==1){
            if(sum == toSelect ){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.addAll(curList);
                for(int i=1;i<=toSelect;i++){
                    temp.add(new Integer(1));
                }
                rv.add(temp);
            }else{
                
            }
            return;
        }
        int added=0;
        createPartRecursive(sum, maxN-1, toSelect, curList, rv);
        
        for(int select=1;select<=toSelect && select * maxN <=sum;select++){
            curList.add(new Integer(maxN));
            added++;
            createPartRecursive(sum-select * maxN, maxN-1, toSelect-select, curList, rv);
        }
        
        for(int i=1;i<=added;i++){
            curList.remove(new Integer(maxN));
        }
        
    }

    private static int[][] createInitialMat(int n) {
        int rv[][] = new int[n][n];
        for(int r=0;r<n;r++){
            int cur = r+1;
            for(int c=0;c<n;c++){
                rv[r][c] =cur;
                cur++;
                if(cur>n){
                    cur=1;
                }
            }
        }
        return rv;
    }

    
    private static void exchangeRows(int[][] mat,int row1,int row2){
        if(row1 == row2){
            return;
        }
        int[] temp = mat[row1];
        mat[row1] = mat[row2];
        mat[row2] = temp;
    }
    
    private static void exchangeCols(int[][] mat,int col1,int col2){
        if(col1==col2){
            return;
        }
        for(int r=0;r<mat.length;r++){
            int temp = mat[r][col1];
            mat[r][col1] =  mat[r][col2];
            mat[r][col2] = temp;
        }
    }

    private static boolean tryDiagonal(int n, int[][] mat, ArrayList<Integer> diagonal) {
        
      return  tryDiagonalRecursive(n, mat, diagonal,0);
        
    }
    private static boolean tryDiagonalRecursive(int n, int[][] mat, ArrayList<Integer> diagonal, int ind) {

        if(ind==n-1){
            if(mat[ind][ind] == diagonal.get(ind)){
                return true;
            }
            return false;
        }
        
        for(int targetRow = ind;targetRow<n;targetRow++){
            int targetCol = -1;
            for(int col = ind;col<n;col++){
                if(mat[targetRow][col] == diagonal.get(ind)){
                    targetCol = col;
                    break;
                }
            }
            if(targetCol != -1){
                exchangeRows(mat, ind, targetRow);
                exchangeCols(mat, ind, targetCol);
                if(tryDiagonalRecursive(n, mat, diagonal, ind+1)){
                    return true;
                }
                exchangeCols(mat, ind, targetCol);
                exchangeRows(mat, ind, targetRow);

                
            }
        }
        
        return false;
    }
    
    
}
