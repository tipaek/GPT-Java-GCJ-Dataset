import java.io.*;
import java.util.*;

public class Solution {
	static int posSwitch = 0;
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		// TEST CASES----------------------------------------------------
		int TC = s.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
		    int N = s.nextInt();
			// READ----------------------------------------------------
			int[][] A = new int[N][N]; 
			for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    A[i][j] = s.nextInt();
                }
            }
			
			int t = 0, r=0, c=0;
			for (int i = 0; i < A.length; i++) {
                t+=A[i][i];
                
                boolean[] rd = new boolean[N+1];
                for (int j = 0; j < A.length; j++) {
                    if(rd[A[i][j]]) {
                        rd[0]=true;
                        break;
                    }
                    rd[A[i][j]]=true;
                }
                if(rd[0])
                    r++;
                
                boolean[] cd = new boolean[N+1];
                for (int j = 0; j < A.length; j++) {
                    if(cd[A[j][i]]) {
                        cd[0]=true;
                        break;
                    }
                    cd[A[j][i]]=true;
                }
                if(cd[0])
                    c++;
            }
			
			
			// SOLVE----------------------------------------------------
			System.out.println("Case #"+tc+": "+t+" "+r+" "+c);
			
			
		}

		// CLOSE----------------------------------------------------
		s.close();
	}
}