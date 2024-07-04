import java.util.*;
import java.io.*;
import java.lang.Math;

public class Solution{

     public static void main(String []args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		int X = 0;
		int Y = 0;
		int num = 0;
		int Flag = 0;
		StringBuilder answerStr = new StringBuilder(); 
		for(int i=1; i<=T; i++) {
		    Flag = 0;
		    X = in.nextInt();
		    Y = in.nextInt();
		    int north = Y;
		    int east = X;
		    String S = in.next();
		    if(north + east == 0){
		        System.out.print("Case #"+ i + ": " + "0" + "\n");
		        Flag = 1;
		        break;
		    }
		    for(int j = 0; j < S.length(); j++){
		        if(S.charAt(j) == 'S'){
		            north = north - 1;
		        }
		        else if(S.charAt(j) == 'W'){
		            east = east -1;
		        }
		        else if(S.charAt(j) == 'N'){
		            north = north + 1;
		        }
		        else{
		            east = east + 1;
		        }
		        if((Math.abs(east) + Math.abs(north)) <= j+1 ) {
		            int ans = j+1;
		            System.out.print("Case #"+ i + ": " + ans + "\n");
		            Flag = 1;
		            break;
		        }
		    }
		    if(Flag == 0){
		        System.out.print("Case #"+ i + ": " + "IMPOSSIBLE" + "\n");
		    }
		}
     }
}