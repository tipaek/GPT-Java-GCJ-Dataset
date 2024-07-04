import java.io.*;
import java.util.*;

class Solution {
	public static void main(String [] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=t;i++) {
			String s = f.readLine(), sout="";
			int current=0;
			for(int j=0;j<s.length();j++) {
				int temp0=s.charAt(j)-'0';
					if (temp0>current)
					{
						int temp=temp0-current;
						for(int k=0;k<temp;k++) sout=sout+'(';
						current=current+temp;
						sout=sout+s.charAt(j);
						System.out.println(j+" "+sout+" "+current+" "+temp);
					}
					else if (temp0<current)
					{
						int temp=current-temp0;
						for(int k=0;k<temp;k++) sout=sout+')';
						sout=sout+s.charAt(j);
						current=current-temp;
					}
					else
						sout=sout+s.charAt(j);
						
		
			}
			int temp0=0;
			if (temp0<current)
			{
				int temp=current-temp0;
				for(int k=0;k<temp;k++) sout=sout+')';
			}
			
			System.out.println("Case #"+i+": "+sout);
		}
	}
}