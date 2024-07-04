
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			for (int t = 1; t <= T; t++) {
		    	int N = in.nextInt();
		    	int K = in.nextInt();
				
		    	
		    	int[] t2 = {2,4};
		    	String [] s2 = {"null","null","1 2\n2 1\n","null","2 1\n1 2\n"};
		    	
		    	int[] t3 = {3,6,9};
		    	String [] s3 ={"null","null","null","1 3 2\n2 1 3\n3 2 1\n","null","null","2 1 3\n3 2 1\n1 3 2\n","null","null","3 2 1\n1 3 2\n2 1 3\n"};
		    	//5,15
		    	int[] t4 = {16, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14};
		    	String [] s4 ={"null","null","null","null","1 2 3 4\n2 1 4 3\n3 4 1 2\n4 3 2 1\n","null","1 2 4 3\n2 1 3 4\n4 3 2 1\n3 4 1 2\n","1 3 4 2\n4 2 1 3\n2 1 3 4\n3 4 2 1\n","3 4 1 2\n2 1 4 3\n1 2 3 4\n4 3 2 1\n","3 4 1 2\n1 2 4 3\n2 1 3 4\n4 3 2 1\n","4 3 2 1\n3 1 4 2\n2 4 1 3\n1 2 3 4\n","2 1 4 3\n3 4 2 1\n4 3 1 2\n1 2 3 4\n","2 1 4 3\n3 4 1 2\n4 3 2 1\n1 2 3 4\n","2 1 3 4\n3 4 2 1\n1 3 4 2\n4 2 1 3\n","3 4 2 1\n4 3 1 2\n2 1 4 3\n1 2 3 4\n","null","4 3 2 1\n3 4 1 2\n2 1 4 3\n1 2 3 4\n"};
		    	//6,24
		    	int[] t5 = {5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 25};
		    	String [] s5 = {"null","null","null","null","null","1 2 3 4 5\n2 1 4 5 3\n3 5 1 2 4\n4 3 5 1 2\n5 4 2 3 1\n","null","1 2 5 4 3\n3 1 2 5 4\n2 4 1 3 5\n4 5 3 2 1\n5 3 4 1 2\n","1 2 3 4 5\n2 1 4 5 3\n3 5 2 1 4\n4 3 5 2 1\n5 4 1 3 2\n","4 5 1 3 2\n2 1 5 4 3\n1 3 2 5 4\n3 2 4 1 5\n5 4 3 2 1\n","3 5 4 1 2\n1 2 5 4 3\n2 3 1 5 4\n4 1 2 3 5\n5 4 3 2 1\n","4 2 1 5 3\n2 1 5 3 4\n1 3 2 4 5\n5 4 3 2 1\n3 5 4 1 2\n","2 1 5 3 4\n1 3 2 4 5\n5 4 3 2 1\n3 5 4 1 2\n4 2 1 5 3\n","2 1 4 5 3\n3 4 5 2 1\n4 5 1 3 2\n5 3 2 1 4\n1 2 3 4 5\n","1 2 3 4 5\n2 1 4 5 3\n3 4 5 2 1\n4 5 1 3 2\n5 3 2 1 4\n","5 3 2 1 4\n1 2 3 4 5\n2 1 4 5 3\n3 4 5 2 1\n4 5 1 3 2\n","4 5 1 3 2\n5 3 2 1 4\n1 2 3 4 5\n2 1 4 5 3\n3 4 5 2 1\n","3 4 5 2 1\n4 5 1 3 2\n5 3 2 1 4\n1 2 3 4 5\n2 1 4 5 3\n","1 3 2 4 5\n5 4 3 2 1\n3 5 4 1 2\n4 2 1 5 3\n2 1 5 3 4\n","5 4 3 2 1\n3 5 4 1 2\n4 2 1 5 3\n2 1 5 3 4\n1 3 2 4 5\n","4 1 2 3 5\n5 4 3 2 1\n3 5 4 1 2\n1 2 5 4 3\n2 3 1 5 4\n","3 2 1 4 5\n5 4 3 2 1\n4 3 5 1 2\n2 1 4 5 3\n1 5 2 3 4\n","5 4 3 2 1\n3 5 1 4 2\n2 1 4 5 3\n1 2 5 3 4\n4 3 2 1 5\n","4 5 3 2 1\n5 4 1 3 2\n1 2 5 4 3\n3 1 2 5 4\n2 3 4 1 5\n","null","5 4 3 2 1\n3 5 4 1 2\n1 2 5 4 3\n2 3 1 5 4\n4 1 2 3 5\n"};
		    			
		    	boolean found = false;
		    	String res = "IMPOSSIBLE";
		    	String mat = "";
		    	if(N==2){
		    		for(int i:t2){
		    			if(K==i) {res = "POSSIBLE"; found = true;
		    			mat = s2[K]; break;}
		    		}
		    	}
		    	
		    	else if(N==3){
		    		for(int i:t3){
		    			if(K==i) {res = "POSSIBLE"; found = true;
		    			mat = s3[K]; break;}
		    		}
		    	}
		    	
		    	else if(N==4){
		    		for(int i:t4){
		    			if(K==i) {res = "POSSIBLE"; found = true;
		    			mat = s4[K]; break;}
		    		}
		    	}
		    	
		    	else if(N==5){
		    		for(int i:t5){
		    			if(K==i) {res = "POSSIBLE"; found = true;
		    			mat = s5[K]; break;}
		    		}
		    	}
		   // System.out.println(s5[17]);
		    	
		    	if(found){
		    		System.out.println("Case #"+t+ ": "+res +"\n"+ mat.substring(0,mat.length()-1));
		    	}
		    	else{
		    		System.out.println("Case #"+t+ ": "+res);
		    	}
		      
		    }

	}

	
	
	
}
