import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		int testCase=1;
		
		while(testCase<=t) {
			
			String s = br.readLine();
			int n =s.length();
			StringBuilder sb = new StringBuilder();
			
			for(int i=0;i<n;i++) {
				
				if(i==0 && s.charAt(i)=='1') {
					sb.append('(');
					sb.append(1);
				}
				
				if( i>0 && s.charAt(i-1)=='1' && s.charAt(i)=='1') {
					sb.append('1');
					continue;
				}
				if(i>0 && s.charAt(i-1)=='0' && s.charAt(i)=='0') {
					sb.append('0');
					continue;
				}
				if(i>0 && s.charAt(i-1)=='1' && s.charAt(i)=='0') {
					sb.append(')');
					sb.append('0');
				}
				if(i>0 && s.charAt(i-1)=='0' && s.charAt(i)=='1') {
					sb.append('(');
					sb.append('1');
				}
					
			}
			if(s.charAt(n-1)=='1') {
				sb.append(')');
			}
			System.out.println("Case #"+testCase+":"+" "+sb.toString());
			
			testCase++;
		}

	}

}
