import java.io.*;
public class Solution {
    public static void main(String args[]) throws IOException {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int t=Integer.parseInt(br.readLine());
    	int c=1;
    	while(c<=t) {
    		int n=Integer.parseInt(br.readLine());
    	   String Cday="";
    	   String Jday="";
    		for(int i=0;i<=1440;i++) {
    			Cday+='0';
    			Jday+='0';
    		}
    		int flag=0;
    		int start[]=new int[n];
    		int end[]=new int[n];
    		for(int i=0;i<n;i++) {
    			String str[]=(br.readLine()).trim().split("\\s+");
    			start[i]=Integer.parseInt(str[0]);
    			end[i]=Integer.parseInt(str[1]);
    		}
    		String res="";
    				for(int i=0;i<n;i++) {
    			int s=start[i];
    			int e=end[i];
    			String Csub=Cday.substring(s+1,e);
    			String Jsub=Jday.substring(s+1,e);
    			if(Csub.indexOf('1')==-1) {
    				Csub=Cday.substring(s,e+1);
    				//length before substring
    				String sb="";
    				String sa="";
    				int lb=s-0;
    				//length after substring
    				int la=1440-e;
    				if(lb>0)
    					sb=Cday.substring(0,s);
    				if(la>0)
    					sa=Cday.substring(e+1);
    				String temp="";
    				for(int j=0;j<Csub.length();j++)
    					temp+='1';
    				Cday=sb+temp+sa;
    				res+='C';
    					}
    			else if(Jsub.indexOf('2')==-1) {
    				Jsub=Jday.substring(s,e+1);
    				//length before substring
    				String sb="";
    				String sa="";
    				int lb=s-0;
    				//length after substring
    				int la=1440-e;
    				if(lb>0)
    					sb=Jday.substring(0,s);
    				if(la>0)
    					sa=Jday.substring(e+1);
    				String temp="";
    				for(int j=0;j<Jsub.length();j++)
    					temp+='2';
    				Jday=sb+temp+sa;
    				res+='J';
    			}
    			else {
    				System.out.println("Case #"+c+":"+" "+"IMPOSSIBLE");
    				flag=1;
    				break;
    			}
    					
    		}
    				if(flag==0)
    			System.out.println("Case #"+c+":"+" "+res);
    				c++;
    	}
    	
    }
}
