import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
	
	public static void main (String[] args) throws java.lang.Exception{
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1;t<=test;t++){
		    int X = sc.nextInt();
		    int Y = sc.nextInt();
		    String M = sc.nextLine();
		    //System.out.println(X);
		    //System.out.println(Y);
		    //System.out.println(M);
		    boolean possible = false;
		    int when = 0;
		    
		    int X_move = X;
		    int Y_move = Y;
		    
		    
		    if(!possible){
		        for(int move = 1;move<M.length();move++){
		            //we have to reach the point in particular moves.
		            //System.out.println(X_move);
		            //System.out.println(Y_move);
		            if(M.charAt(move) == 'N'){
		                
		                Y_move++;
		            } 
		            if(M.charAt(move) == 'S'){
		                Y_move--;   
		            }
		            if(M.charAt(move) == 'E'){
		                X_move++;    
		            }
		            if(M.charAt(move) == 'W'){
		                X_move--;    
		            }
		            
		            int difference = Math.abs(X_move) + Math.abs(Y_move);
		            
		            if(difference <= move){
		                possible = true;
		                when = move;
		                break;
		            }
		        }
		    }
		    if(possible){
		        System.out.println("Case #"+ t + ": " + when);    
		    }
		    else{
		        System.out.println("Case #"+ t + ": IMPOSSIBLE");
		    }
		}
	}
}
