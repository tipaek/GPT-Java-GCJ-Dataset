import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	static int T, b, n;
	public static void main(String[] args) throws NumberFormatException, IOException  {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	   	T = Integer.parseInt(br.readLine());
	   	for(int testcase = 1; testcase <= T; testcase++) {
	   		String str = br.readLine();
	   		b  = 0;
	   		bw.write("Case #"+ testcase + ": ");
	   		for(char c : str.toCharArray()) {
	   			n = c - '0';
	   			while(b < n) {
	   				bw.write("(");
	   				b++;
	   			}
	   			while(b > n) {
	   				bw.write(")");
	   				b--;
	   			}
	   			bw.write(c);
	   		}
	   		for(;b>0; b--) bw.write(")");
	   		bw.newLine();
	   		bw.flush();
	   	}
	   
	    	
	
	}  
}
