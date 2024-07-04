import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	int k=0;
	int r=0;
	int c=0;
	
	public Solution(Scanner in) { 
        int N = in.nextInt();
        byte[][] M = new byte[N][N];
        
        int[] row_flags = new int[N+1];
        int[] col_flags = new int[N+1];
        for (int i = 0; i < N; i++) {
        	row_flags[i] = 0;
        	boolean rowRepeat = false;
        	
        	for (int j = 0; j < N ; j++){
	 			M[i][j] = in.nextByte();
	 			if((row_flags[i] & (int)(Math.pow(2,M[i][j]))) == 0){	 				
	 				row_flags[i] |= (int)(Math.pow(2,M[i][j]));
	 			}
	 			else if (rowRepeat == false){
	 				rowRepeat = true;
	 				r++;
	 			}	 			
	 			if(i==j) {
	 				k += M[i][j];
	 			}	
        	}
		}
        for (int j = 0; j < N; j++) {
        	col_flags[j] = 0;
        	boolean colRepeat = false;
        	
        	for (int i = 0; i < N ; i++){
	 			if((col_flags[j] & (int)(Math.pow(2,M[i][j]))) == 0){
	 				col_flags[j] |= (int)(Math.pow(2,M[i][j]));
	 			}
	 			else if (colRepeat == false){
	 				colRepeat = true;
	 				c++;
	 			}
        	}
        	
        }
	}

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        int TS = in.nextInt();
        ArrayList<Solution> solution = new ArrayList<Solution>();
        for (int ts = 0; ts < TS; ts++ ) {
        	solution.add(new Solution(in));
        }
        in.close();
        for (int ts = 0; ts < TS; ts++ ) {
        	Solution s = solution.get(ts);
        	System.out.println("Case #" + (ts+1) + ": " + s.k + " "+  s.r + " " + s.c);
        }
	}
}
