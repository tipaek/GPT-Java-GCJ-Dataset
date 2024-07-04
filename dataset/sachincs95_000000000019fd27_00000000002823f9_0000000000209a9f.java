

import java.util.*;
import java.lang.*;
import java.io.*;


class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for(int t=0;t<test;t++){
			String ts = br.readLine();
			String result = "";
			int bra = 0;
			int len = ts.length();
			int d1 = Integer.parseInt(ts.substring(0,1));
			bra = d1;
			for(int k=0;k<bra;k++){
				result += "(";
			}
			result += ts.charAt(0);
			for(int i=1;i<len;i++){
				int d = Integer.parseInt(ts.substring(i,i+1) );
				
				if(d==bra){
					result += ts.charAt(i);
				}
				else if (d>bra){
					for(int k=0;k<d-bra;k++){
						result += "(";
					}
					bra = d;
					result += ts.charAt(i);
				}
				else{
					for(int k=0;k<bra-d;k++){
						result += ")";
					}
					bra = d;
					result += ts.charAt(i);
				}
			}
			if (bra > 0){
				for(int k=0;k<bra;k++){
					result += ")";
				}
			}
			
			System.out.println("Case #"+(t+1)+": "+result);
		}
	}
}