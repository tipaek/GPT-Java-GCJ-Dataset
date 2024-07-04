import java.util.*;
import java.io.*;

public class Solution 
{
    public static void main (String[] args) 
    {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        //System.out.println(open+" "+close+" "+add);
        for (int i = 1; i <= t; ++i) {
        	String str = in.next();
        	int len = str.length();
        	int open=0,close=0,add=0;
        	String ans= "";
        	
        	for(int j=0;j<len;j++){
        		int dig = str.charAt(j)-'0';
        		open=dig;
        		add=open+close;
        		if(add>0){
        			ans=ans+(repeat(1,add));
        		}
        		else if(add<0){
        			ans=ans+(repeat(0,-1*add));
        		}
        		ans=ans+str.charAt(j);
        		close=-1*dig;
        	}
        	if(close!=0)
        		ans=ans+(repeat(0,-1*close));
        	System.out.println("Case #"+i+": "+ans);
        }
	}
	
	public static String repeat(int oOrC,int num){
		String ans="";
		if(oOrC==1){
			for(int i=0;i<num;i++){
				ans+="(";
			}
		}
		else{
			for(int i=0;i<num;i++){
				ans+=")";
			}
		}
		return ans;
	}
    
}