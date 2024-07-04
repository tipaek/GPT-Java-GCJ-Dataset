
import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = sc.nextInt();
		for(int i=0; i<n;i++){
		    int x = sc.nextInt();
		    int y = sc.nextInt();
		    int mx=0;
		    int my=0;
		    int xgap, ygap;
		    int result = 0;
		    System.out.print("Case #" + (i+1) + ": ");
		    String root = sc.next();
		    if(x==0 && y==0) {
		    	result = 0;
		    }
		    else {
		    	for(int j=0;j<root.length();j++) {
		    		char go = root.charAt(j);
		    		if( go == 'S') y -=1;
		    		else if( go == 'N') y +=1;
		    		else if( go == 'E') x +=1;
		    		else if( go == 'W') x -=1;
		    		result++;
		    		xgap = Math.abs(x-mx);
		    		ygap = Math.abs(y-my);
		    		if(xgap > ygap) {
		    			if(x > mx) mx++;
		    			else if(x < mx) mx--;
		    		}
		    		else {
		    			if(y> my)my++;
		    			else if(y < my) my--;
		    		}
		    		if(x == mx && y == my) {
		    			break;
		    		}
		    		if(j == root.length()-1) {
		    			result = -1;
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

