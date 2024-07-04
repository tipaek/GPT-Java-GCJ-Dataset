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
			char[][] inL = new char[N][];
			char[][] inR = new char[N][];
			for (int i = 0; i < N; i++) {
			    String[] str = s.next().split("\\*");
                inL[i] = str[0].toCharArray();
                inR[i] = new StringBuilder(str[1]).reverse().toString().toCharArray();
            }
		    
		    // SOLVE----------------------------------------------------
			String resL = resolvePart(inL);
			String resR = resolvePart(inR);
			
			String res = resL + new StringBuffer(resR).reverse().toString();
			if("*".equals(resL) || "*".equals(resR))
			    res = "*";
			
			System.out.println("Case #"+tc+": "+res);
		}

		// CLOSE----------------------------------------------------
		s.close();
	}
    private static String resolvePart(char[][] in) {
        StringBuffer res = new StringBuffer();
        int[] p = new int[in.length];
        boolean find = true;
        boolean valid = true;
        while(find) {
            find = false;
            char cur = '0';
            //boolean allStars = true;
            for (int i = 0; i < in.length; i++) {
                if(p[i]==in[i].length)
                    continue;
                
                find = true;
                //if(in[i][p[i]] != '*'){
                    //allStars = false;
                    if( cur=='0' || cur == in[i][p[i]]) { 
                        cur = in[i][p[i]];
                        p[i]++;
                    }else { //if(p[i]==0 || in[i][p[i]-1]!='*') {
                        find = false;
                        valid = false;
                        break;
                    }
                //}
            }
            
              if(cur!='0')
                res.append(cur);
            
//            if(allStars) {
//                for (int i = 0; i < in.length; i++)
//                    p[i]++;
//            }
        }
        
        if(!valid)
            res = new StringBuffer("*");
        
        return res.toString();
    }
}