import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static void main (String[] args){
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    for(int tt = 1; tt <= t; tt++){
	        int X = sc.nextInt();
	        int Y = sc.nextInt();
	        String M = sc.next();
	        int i = 0;
	        boolean isMeet = false;
	        while(i < M.length()){
	            if(M.charAt(i) == 'N'){
	                Y++;
	            }
	            else if(M.charAt(i) == 'S'){
	                Y--;
	            }
	            else if(M.charAt(i) == 'E'){
	                X++;
	            }
	            else if(M.charAt(i) == 'W'){
	                X--;
	            }
	            i++;
	            int dis = Math.abs(X) + Math.abs(Y);
	            if(i >= dis){
	                isMeet = true;
	                break;
	            }
	        }
            if(isMeet){
    	        System.out.println("Case #" + tt + ": " + i);
            }
            else{
    	        System.out.println("Case #" + tt + ": IMPOSSIBLE");
            }
	    }
	}
}