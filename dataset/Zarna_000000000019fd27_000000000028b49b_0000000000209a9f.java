import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String a[]) throws Exception{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int t=Integer.parseInt(br.readLine()),test=1;
		while(t-->0) {
			
			String str;
			str=br.readLine();
			int j;
			String snull="";
			StringBuffer sb = new StringBuffer(snull);
    		//sb.insert(position, ch);
    		for(int i=0;i<Character.getNumericValue(str.charAt(0));i++)
    			sb.insert(0,'(');
    		j=sb.length();
    		sb.insert(j,str.charAt(0));
    		j++;
    		for(int i=1;i<str.length();i++) {
    			//if(str.charAt(i)=='1' && str.charAt(i-1)=='0')
    			for(int k=Character.getNumericValue(str.charAt(i-1));k<Character.getNumericValue(str.charAt(i));k++) {
    				sb.insert(j,'(');
    				j++;
    			}
    			//if(str.charAt(i)=='0' && str.charAt(i-1)=='1')
    			for(int k=Character.getNumericValue(str.charAt(i));k<Character.getNumericValue(str.charAt(i-1));k++) {
    				sb.insert(j,')');
    				j++;
    			}
				sb.insert(j,str.charAt(i));
				j++;
    		}
    		//if(str.charAt(str.length()-1)=='1')
    		for(int i=0;i<Character.getNumericValue(str.charAt(str.length()-1));i++)
    		{
    			sb.insert(j,')');
    			j++;
    		}
    		System.out.println("Case #"+test+": "+sb.toString());
    		test++;
		}
	}
}