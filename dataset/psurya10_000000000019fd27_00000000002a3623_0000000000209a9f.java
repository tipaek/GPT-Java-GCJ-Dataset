import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int q=0;q<t;q++) {
            String ip=sc.next();            
            String ans=""; 
            if(ip.charAt(0)=='1') {
            	ans=ans.concat("(1");
        	}
        	else {
            	ans+=ip.charAt(0);
            }
            for(int i=1;i<ip.length();i++) {
            	if(ip.charAt(i)=='1' && ip.charAt(i-1)=='1') {
            		ans+=ip.charAt(i);
            	}
            	else if(ip.charAt(i)=='1') {
            		ans=ans.concat("(");
            		ans=ans+ip.charAt(i);
            	}
            	else if(ip.charAt(i)=='0' && ip.charAt(i-1)=='1') {
            		ans=ans+(")");
            		ans=ans+ip.charAt(i);
            	}
            	else {
            		ans=ans+ip.charAt(i);
            	}
            }
            if(ip.charAt(ip.length()-1)=='1') {
            	ans=ans.concat(")");
        	}
            System.out.println("Case #"+q+":"+ans);
        }
        sc.close();
    }
}