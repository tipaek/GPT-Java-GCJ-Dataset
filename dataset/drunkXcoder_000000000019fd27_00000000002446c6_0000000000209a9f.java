import java.io.*;
public class Solution {
    public static void main(String args[]) throws IOException {
    	BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    	int t=Integer.parseInt(br.readLine());
    	int c=1;
    	while(c<=t) {
    		String s=br.readLine();
    		//finding the first index after 0 and also if it exists
    		int index=0;
    		for(int i=0;i<s.length();i++) {
    			if(s.charAt(i)!='0') {
    				index=i;
    			     break;
    			}
    		}
    		
    		String test="";
    		for(int i=0;i<Integer.parseInt(String.valueOf(s.charAt(index)));i++)
    			test+='(';
    		test+=s.charAt(index);
    		int max=Integer.parseInt(String.valueOf(s.charAt(index)));
    		int count=max;
    		for(int i=index+1;i<s.length();i++) {
    			int num=Integer.parseInt(String.valueOf(s.charAt(i)));
    			if(num>=count) {
    				int diff=num-count;
    				max=num;
    				for(int j=0;j<diff;j++)
    	    			test+='(';
    				test+=s.charAt(i);
    				count+=diff;
    				}
    			else {
    				int diff=count-num;
    				for(int j=0;j<diff;j++)
    					test+=')';
    				test+=s.charAt(i);
    				count-=diff;
    				
    			}
    		}
    		for(int i=0;i<count;i++)
    			test+=')';
                    int Zcount=0;
                    String res="";
                    while(Zcount<index) { 
                    	res+='0';
                       Zcount++;
                    }
           res+=test;
    	System.out.println("Case #"+c+" "+res);
    	c++;
    	}
    }
}