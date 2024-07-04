import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try( Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))) ) {
	        int t = in.nextInt();
	        
	        int last, tmpNum;
	        String str, res;

	        for (int i = 1; i <= t; ++i) {
	        	last = 0;
	        	res = "";
	        	
	        	str = in.next();
	        	for( int c = 0; c < str.length(); c++ ) {
	        		tmpNum = Character.getNumericValue(str.charAt(c));
	        		
	        		last -= tmpNum;
	        		
	        		if( last < 0 )
	        			for( int p = 0; p < Math.abs(last); p++ ) res += "(";
	        		else if( last > 0 )
	        			for( int p = 0; p < last; p++ ) res += ")";
	        		
	        		res += tmpNum;
	        		last = tmpNum;
	        	}
	        	
	        	for( int p = 0; p < last; p++ ) res += ")";
	        	
	        	System.out.println("Case #" + i + ": " + res);
	        }
		} catch( Exception e ) {
			e.printStackTrace();
		}

	}

}
