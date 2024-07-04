import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int t=s.nextInt();
        for(int k=1;k<=t;k++) {
        	int n=s.nextInt();
        	String ans="";
        	for(int i=0;i<n;i++) {
        		String str=s.next();
        		String ref=str.substring(1);
        		if(i==0) {
        			ans=ref;
        		}
        		else {
        			if(ref.contains(ans) || ans.contains(ref)) {
        				ans=ans.length()>ref.length()?ans:ref;
        			}
        			else {
        				ans="*";
        				
        			}
        		}
        	}
        	System.out.println("Case #"+k+": "+ans);
        }
		
	}
}