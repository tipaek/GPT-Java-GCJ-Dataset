package gcodejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author adarshbhattarai on 2020-04-04
 * @project untitled
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = sc.nextInt();
        for(int i=1;i<=testcases;i++) {
            String N = sc.next();
            System.out.println("Case #" + i + ": " + solve(N));
        }
    }

    private static String solve(String n) {

       StringBuilder sb = new StringBuilder();
        char[] chr = n.toCharArray();
        Stack<Integer> stk = new Stack();
        for(char c : n.toCharArray())
            stk.push(Integer.parseInt(String.valueOf(c)));
       int prevClosure=0;

        while(!stk.isEmpty()){
            int val = stk.pop();
            int noOfClosureReqd=0;
            if(val>=prevClosure){
                noOfClosureReqd=val-prevClosure;
            }else{
                int openingReqd =  prevClosure-val;
                for(int i=0;i<openingReqd;i++){
                    sb.append("(");
                    prevClosure--;
                }

            }
            for(int i=0;i<noOfClosureReqd;i++){
                sb.append(")");
                prevClosure++;
            }
            sb.append(val);
        }
        while(prevClosure-->0){
            sb.append("(");
        }
        return sb.reverse().toString();
    }
}
