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
			int N = s.nextInt();
			
			// SOLVE----------------------------------------------------
			StringBuffer res = new StringBuffer("1 1\n");
			
			if(N>=2)
			    res.append("2 1\n");
			
			if(N>2) {
			    int sum = 2;
			    int v = 2;
			    while(sum+v<=N) {
			        sum += v;
			        res.append("2 "+v+"\n");
			        v++;
			    }
			    
			    while(sum<N) {
                    sum++;
                    v--;
                    res.append("1 "+v+"\n");
                }
			    
			}
			    
			System.out.print("Case #"+tc+":\n"+res);
			
			
		}

		// CLOSE----------------------------------------------------
		s.close();
	}
}