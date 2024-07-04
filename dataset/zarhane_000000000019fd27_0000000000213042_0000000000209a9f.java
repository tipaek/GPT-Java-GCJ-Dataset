import java.io.*;
import java.util.*;

public class Solution {
	static int posSwitch = 0;
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		// TEST CASES----------------------------------------------------
		int TC = s.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			// READ----------------------------------------------------
			char[] A = s.next().toCharArray();
			
			// SOLVE----------------------------------------------------
			StringBuffer res = new StringBuffer();
			int letter = A[0]-'0';
			for (int i = 0; i < letter; i++) {
                res.append("(");
            }
			
			
			for (int i = 0; i < A.length-1; i++) {
                res.append(A[i]);
                int dif = A[i+1] - A[i];
                for (int j = 0; j < Math.abs(dif); j++) {
                    res.append(dif>0 ? "(" : ")");
                }
            }
			
			res.append(A[A.length-1]);
			
			letter = A[A.length-1]-'0';
            for (int i = 0; i < letter; i++) {
                res.append(")");
            }
			
			System.out.println("Case #"+tc+": "+res);
			
			
		}

		// CLOSE----------------------------------------------------
		s.close();
	}
}