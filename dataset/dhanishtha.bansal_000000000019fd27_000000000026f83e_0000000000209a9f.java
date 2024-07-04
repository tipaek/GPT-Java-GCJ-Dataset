import java.util.*;
import java.lang.*;
import java.io.*;
class Solution
 {
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int test = Integer.parseInt(br.readLine()); 
  
	    for(int idx = 1; idx <= test; idx++) {
	        String str = br.readLine().trim();
	        int[] num = new int[str.length()];
	        for(int i = 0; i < str.length(); i++) {
	            num[i] = Character.getNumericValue(str.charAt(i));
	        }
	        int  i = 0;
	        int  depth = 0;
	        StringBuffer res = new StringBuffer();
	        while(i < str.length()) {
	            if(num[i] != 0) {
	                if(num[i] < depth) {
	                    //add ')' before num[i] ; depth-num[i] times
	                    int j = depth-num[i];
	                    depth = j; //left depth
	                    while(j != 0) {
	                        res.append(')');
	                        j--;
	                    }
	                    res.append(num[i]);
	                }
	                else if(num[i] > depth) {
	                    // add '(' before num[i] ; num[i]-depth times
	                    int j = num[i] - depth;
	                    depth = j;
	                    while(j != 0) {
	                        res.append('(');
	                        j--;
	                    }
	                    res.append(num[i]);
	                }
	                else {
	                    res.append(num[i]);
	                }
	            }
	            else {
	                //add ')' before num[i]; depth times
	                int j = depth;
	                
	                while(j != 0) {
	                    res.append(')');
	                    j--;
	                }
	                res.append(num[i]);
	                depth = 0;
	            }
	            i++;
	        }
	        while(depth != 0) {
	            res.append(')');
	            depth--;
	        }
	        System.out.print("Case #" + idx + ": ");
	        System.out.println(res);
	    }
	}
}