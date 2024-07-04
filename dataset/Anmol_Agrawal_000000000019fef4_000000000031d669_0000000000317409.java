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
	        int req = (X + Y)/2;
	        int i = 0;
	        boolean isMeet = false;
	        for(; i < M.length(); i++){
	            int dis = Math.abs(X) + Math.abs(Y);
	            if(dis <= req){
	                isMeet = true;
	                break;
	            }
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
	        }
	        int dis = Math.abs(X) + Math.abs(Y);
            if(dis <= req){
                isMeet = true;
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