

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
        
        char str[] = in.readLine().trim().toCharArray();
        int curDep=0;
        StringBuffer sb = new StringBuffer();
        
        for(int i=0;i<str.length;i++){
            int dVal = str[i] -'0';

            while(curDep>dVal){
                sb.append(")");
                curDep--;
            }

            while(curDep<dVal){
                sb.append("(");
                curDep++;
            }
            sb.append(str[i]);
        }
        
        while(curDep>0){
            sb.append(")");
            curDep--;
        }
        

        System.out.println("Case #"+caseNo+": "+sb.toString());
    }
    
    
}
