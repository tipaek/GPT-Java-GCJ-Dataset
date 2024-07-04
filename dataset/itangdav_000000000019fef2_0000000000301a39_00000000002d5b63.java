
import java.io.*;
import java.util.*;

public class Solution {
	static int x1,x2,y1,y2;
	public static void solve(Scanner input, int stage) {
		
	    if(stage==1){
	    	System.out.println(x1+" "+0);
	    	String s = input.next();
	    	if(s.equals("CENTER")) return;
	    	else if(s.equals("WRONG")) return;
	    	else if(s.equals("HIT")){
	    		stage++;
	    	}
	    	else {
	    		x1++;
	    	}
	    }
	    else if(stage==2){
	    	System.out.println(x2+" "+0);
	    	String s = input.next();
	    	if(s.equals("CENTER")) return;
	    	else if(s.equals("WRONG")) return;
	    	else if(s.equals("HIT")){
	    		stage++;
	    	}
	    	else x1--;
	    }
	    else if(stage==3){
	    	System.out.println(0+" "+y1);
	    	String s = input.next();
	    	if(s.equals("CENTER")) return;
	    	else if(s.equals("WRONG")) return;
	    	else if(s.equals("HIT")){
	    		stage++;
	    	}
	    	else y1++;
	    }
	    else if(stage==4){
	    	System.out.println(0+" "+y2);
	    	String s = input.next();
	    	if(s.equals("CENTER")) return;
	    	else if(s.equals("WRONG")) return;
	    	else if(s.equals("HIT")){
	    		stage++;
	    	}
	    	else y2--;
	    }
	    else{
	    	System.out.println((x1+x2)/2 + " " + (y1+y2)/2);
	    	String s = input.next();
	    	return;
	    }
	    solve(input, stage);
	}
	
	public static void main (String[]args) throws IOException{
		Scanner input = new Scanner(System.in);
	    int T = input.nextInt();
	    int A=input.nextInt();
	    int B=input.nextInt();
		for(int test =1; test<=T;test++){
			x1=-1000000000;
			x2=1000000000;
			y1=-1000000000;
			y2=1000000000;
			solve(input, 1);
//			System.out.println("Case #" + test + ": " + solve(x,y));
			
		}	
	}
			
		
}
