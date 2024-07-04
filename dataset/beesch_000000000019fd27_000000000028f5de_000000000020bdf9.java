import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try( Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))) ) {
	        int t = in.nextInt();
	        
	        int[][] container = new int[1441][2];
	        for (int i = 1; i <= t; ++i) {
	        	int n = in.nextInt();
	        	
	        	boolean isImpossible = false;
	        	
	        	for( int x = 0; x < 1441; x++ ) {
	        		container[x][0] = 0;
	        		container[x][1] = 0;
	        	}
	        	
	        	for( int a = 1; a <= n; ++a ) {	
	        		int start = in.nextInt();
	        		int end = in.nextInt();
	        		
	        		for( int m = start; m < end; m++ ) {
	        			if( container[m][0] == 0 )
	        				container[m][0] = a;
	        			else if( container[m][1] == 0 )
	        				container[m][1] = a;
	        			else {
	        				isImpossible = true;
	        				break;
	        			}
	        		}
	        		
	        		if( isImpossible )
	        			break;
	        	}
	        	
	        	if( isImpossible )
	        		System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
	        	else {
	        		char[] result = new char[n];
	        		
	        		int tmp;
	        		for( int x = 1; x < 1441; x++ ) {
	        			if( container[x-1][1] == container[x][0] && container[x][0] != 0 ) {
	        				tmp = container[x][0];
	        				container[x][0] = container[x][1];
	        				container[x][1] = tmp;
	        			} else if( container[x-1][0] == container[x][1] && container[x][1] != 0 ) {
	        				tmp = container[x][1];
	        				container[x][1] = container[x][0];
	        				container[x][0] = tmp;
	        			}
	        			
	        			if( container[x-1][0] != container[x][0] && container[x-1][0] != 0 )
	        				result[container[x-1][0] - 1] = 'C';
	        			if( container[x-1][1] != container[x][1] && container[x-1][1] != 0 )
	        				result[container[x-1][1] - 1] = 'J';
	        		}
	        		System.out.println("Case #" + i + ": " + "");
	        	}
	        }
		}
	}
}
