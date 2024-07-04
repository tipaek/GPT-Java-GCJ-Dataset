import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String a[]) throws Exception{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt(),test=1;
		while(t-->0) {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String str=br.readLine();
			int j;
			String snull="";
			StringBuilder sb = new StringBuilder(snull);
    		//sb.insert(position, ch);
    		if(str.charAt(0)=='1')
    			sb.insert(0,'(');
    		j=sb.length();
    		sb.insert(j,str.charAt(0));
    		j++;
    		for(int i=1;i<str.length();i++) {
    			if(str.charAt(i)=='1' && str.charAt(i-1)=='0') {
    				sb.insert(j,'(');
    				j++;
    			}
    			if(str.charAt(i)=='0' && str.charAt(i-1)=='1') {
    				sb.insert(j,')');
    				j++;
    			}
				sb.insert(j,str.charAt(i));
				j++;
    		}
    		if(str.charAt(str.length()-1)=='1')
    			sb.insert(j,')');
    		
    		System.out.println("Case #"+test+": "+sb.toString());
    		test++;
		}
	}
}