
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			for (int t = 1; t <= T; t++) {
		    	int N = in.nextInt();
				int[][] matrix = new int[N][N];
				int k = 0;
				int r = 0;
				int c = 0;
				
				HashSet<Integer> rs = new HashSet<Integer>();
				boolean rr = false;
				for(int i=0; i<N;i++){
					rs.clear();
					rr = false;
					for(int j=0; j<N; j++){
						matrix[i][j] = in.nextInt();
						if(i==j) k+=matrix[i][j];
						if(rs.isEmpty()){rs.add(matrix[i][j]);}
						else{
							if(rs.contains(matrix[i][j])) rr=true;
							rs.add(matrix[i][j]); }
					}
					if(rr) r++;
				}
		    	
				
				HashSet<Integer> cs = new HashSet<Integer>();
				boolean cr = false;
				for(int i=0; i<N;i++){
					cs.clear();
					cr = false;
					for(int j=0; j<N; j++){
						if(cs.isEmpty()){cs.add(matrix[j][i]);}
						else{
							if(cs.contains(matrix[j][i])) cr=true;
							cs.add(matrix[j][i]); }
					}
					if(cr) c++;
				}
		    	
		    	
		    	
		    	System.out.println("Case #"+t+ ": " + k+" "+r+" "+c);
		      
		    }

	}

	
	
	
}
