package deep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeepNesting {

	public static void main(String[] args) throws IOException {

		int T;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
	    T = Integer.parseInt(reader.readLine());
	    if(T>=1 && T<=100)
	    for(int tt=0;tt<T;tt++) {
	    	String S = reader.readLine();
	    	if(S.length()>=1 && S.length()<=100) {
	    		
	    		int l = S.length();
	    		String str="";
	    		for(int i=0 ; i<l ;) {
	    			if(S.charAt(i)=='0')
	    				{
	    				str=str+"0";
	    				i++;
	    				}
	    			else {
	    				int s = i;
	    				str +="(";
	    				int e = i;
	    				while(e<l && S.charAt(e)=='1')
	    					e++;
	    				
	    				str = str+ S.substring(s,e);
	    				str+=")";
	    				i=e;
	    			}
	    			
	    		}
	    		System.out.println("Case #"+(tt+1)+": "+str);
	    	}
	    }

	}

}
