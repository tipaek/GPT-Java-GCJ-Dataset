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
			String strnull="";
			StringBuffer strbuf = new StringBuffer(strnull);
    		for(int i=0;i<Character.getNumericValue(str.charAt(0));i++)
    			strbuf.insert(0,'(');
    		j=strbuf.length();
    		strbuf.insert(j,str.charAt(0));
    		j++;
    		for(int i=1;i<str.length();i++) {
    			for(int k=Character.getNumericValue(str.charAt(i-1));k<Character.getNumericValue(str.charAt(i));k++) {
    				strbuf.insert(j,'(');
    				j++;
    			}
    			
    			for(int k=Character.getNumericValue(str.charAt(i));k<Character.getNumericValue(str.charAt(i-1));k++) {
    				strbuf.insert(j,')');
    				j++;
    			}
				strbuf.insert(j,str.charAt(i));
				j++;
    		}
    		
    		for(int i=0;i<Character.getNumericValue(str.charAt(str.length()-1));i++)
    		{
    			strbuf.insert(j,')');
    			j++;
    		}
    		System.out.println("Case #"+test+": "+strbuf.toString());
    		test++;
		}
	}
}