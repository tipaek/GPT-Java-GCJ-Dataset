import java.util.*;
import java.lang.*;
public class Solution {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		int x=1;
		while(t>0)  {
		String s=scan.next();
		StringBuilder sb=new StringBuilder();
		int count=0;
		int num=0;
	    for(int i=0;i<s.length();i++) {
	    	num=count;
	    	if(s.charAt(i)=='0')  {
	    		while(count!=0) {
	    			sb.append(")");
	    			count--;
	    		}
	    		sb.append("0");
	    		continue;
	    	}
	    	
	    	int n=s.charAt(i)-'0';
	    	if(count==n) {
	    		sb.append(s.charAt(i));
	    		continue;
	    	}
	    	if(count>n)  {
	    	for(int j=0;j<(num-n);j++)  {
	    		sb.append(")");
	    		count--;
	    	}}
	    	if(count<n) {
	    	for(int j=0;j<(n-num);j++) {
	    		sb.append('(');
	    		count++;
	    	}}
          sb.append(s.charAt(i));
		}
	    if(count!=0) {
	    	for(int i=0;i<count;i++) {
	    		sb.append(")");
	    		}
	    }
		System.out.print("Case #"+x+":"+sb.toString());
		x++;
		t--;
	}
}
}