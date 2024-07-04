

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


    private static void executeOneTc(int caseNo,BufferedReader in) throws IOException {
        
        StringTokenizer stk = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int trace = Integer.parseInt(stk.nextToken());
        
        List<ArrayList<Integer>> partitions = createPartitions(trace, n);
        
        for(ArrayList<Integer> diag : partitions){
        int mat[][] = new int[n][n];
        boolean[][] rowFlags = new boolean[n][n+1];
        boolean[][] colFlags = new boolean[n][n+1];
        
        for(int i=0;i<n;i++){
            mat[i][i] = diag.get(i);
            rowFlags[i][diag.get(i)] = true;
            colFlags[i][diag.get(i)] = true;
        }
        
        boolean rslt = doItRecursiveExtended(n,mat,0,0,rowFlags,colFlags,trace);
        if(rslt)

        {
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
    

    public static boolean doItRecursiveExtended(int n, int[][] mat, int rowNum, int colNum, boolean[][] rowFlags, boolean[][] colFlags, long trace) {
       if(rowNum == n-1 & colNum == n-1){
            return true;
       }
       if(rowNum == colNum){
           return doItRecursiveExtended(n, mat, rowNum, colNum+1, rowFlags, colFlags, trace);
       }
       
        for(int val=1;val<=n;val++){
            if(!rowFlags[rowNum][val] && !colFlags[colNum][val]){
                rowFlags[rowNum][val] = true;
                colFlags[colNum][val] = true;
                mat[rowNum][colNum] = val;
                boolean rslt = false;
                if(colNum<n-1){
                    rslt = doItRecursiveExtended(n, mat, rowNum, colNum+1, rowFlags, colFlags, trace);
                } else{
                    rslt = doItRecursiveExtended(n, mat, rowNum+1, 0, rowFlags, colFlags, trace);
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
