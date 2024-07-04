import java.util.*;
import java.io.*;
public class Solution {
	public static int x=0, y=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = sc.nextInt();
		for(int i=0; i<n;i++){
		    x = sc.nextInt();
		    y = sc.nextInt();
		    int result =0;
		    System.out.print("Case #" + (i+1) + ": ");
		    String root = sc.next();
		    if(x == 0 && y==0) {
		    	result = 0; 
		    }
		    else {
		    	for(int j=0;j<root.length();j++) {
		    		if(x > 0) {
		    			x--;
		    		}
		    		else {
		    			y--;
		    		}
		    		result++;
		    		if(x ==0 && y==0) {
		    			break;
		    		}
		    		char go = root.charAt(j);
		    		if( go == 'S') y -=1;
		    		else if( go == 'N') y +=1;
		    		else if( go == 'E') x +=1;
		    		else if( go == 'W') x -=1;
		    		if(x ==0 && y==0) {
		    			break;
		    		}
		    		if(j == root.length()-1) {
		    			result = -1;
		    			break;
		    		}
		    		
			    }
		    }
		    if(result == -1) {
		    	System.out.println("IMPOSSIBLE");
		    }
		    else {
		    	System.out.println(result);
		    }
		    
		    
		}
		

	}

}

