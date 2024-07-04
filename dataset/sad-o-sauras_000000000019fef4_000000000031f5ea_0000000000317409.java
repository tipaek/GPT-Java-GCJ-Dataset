import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main{
	
	public static void main (String[] args){
	    
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int t = 1;t<=test;t++){
		    int X = sc.nextInt();
		    int Y = sc.nextInt();
		    String M = sc.next();
		    //System.out.println(X);
		    //System.out.println(Y);
		    //System.out.println(M);
		    boolean possible = false;
		    int when = 0;
		    
		    int X_move = X;
		    int Y_move = Y;
		    
		    if(!possible){
		        for(int move = 1;move<=M.length();move++){
		            //we have to reach the point in particular moves.
		            if(M.charAt(move-1) == 'N'){
		                Y_move++;
		            } 
		            if(M.charAt(move-1) == 'S'){
		                Y_move--;   
		            }
		            if(M.charAt(move-1) == 'E'){
		                X_move++;    
		            }
		            if(M.charAt(move-1) == 'W'){
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
