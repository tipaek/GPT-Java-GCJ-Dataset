
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
        int mat[][] = new int[n][n];
        
        for(int r=0;r<n;r++){
            stk = new StringTokenizer(in.readLine());
            for(int c=0;c<n;c++){
                mat[r][c] = Integer.parseInt(stk.nextToken());
            }
        }
        
        int trace = 0;
        for(int i=0;i<n;i++){
            trace+= mat[i][i];
        }
        
        int rowCount=0;
        for(int r=0;r<n;r++){
            boolean flags[] = new boolean[n+1];
            for(int c=0;c<n;c++){
                if(flags[ mat[r][c]]){
                    rowCount++;
                    break;
                }
                flags[ mat[r][c]] = true;
            }
        }
        
        int colCount =0;
        for(int c=0;c<n;c++){
            boolean flags[] = new boolean[n+1];
            for(int r=0;r<n;r++){
                if(flags[ mat[r][c]]){
                    colCount++;
                    break;
                }
                flags[ mat[r][c]] = true;
            }
        }
        

        System.out.println("Case #"+caseNo+": "+trace+" "+rowCount+" "+colCount);
    }
    
    
}
