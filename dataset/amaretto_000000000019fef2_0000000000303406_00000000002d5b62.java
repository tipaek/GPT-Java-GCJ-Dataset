import java.math.*;
import java.io.*;
import java.util.*;
public class Solution {
	
	public static String helper(long x, long y, String str,
	    long cx, long cy, long curr
	){
	    if(str.length()>=12){
	        return str;
	    }
	    if(x==cx && y==cy) return str;
	    if(cx+curr==x){
	        str+='E';
	        return helper(x,y,str,x,cy,curr*2L);
	    }
	    if(cx-curr==x){
	        str+='W';
	        return helper(x,y,str,x,cy,curr*2L);
	    }
	    if(cy-curr==y){
	        str+='S';
	        return helper(x,y,str,cx,y,curr*2L);
	    }
	    if(cy+curr==y){
	        str+='N';
	        return helper(x,y,str,cx,y,curr*2L);
	    }
	    String poss1 = helper(x,y,str+"E",cx+curr,cy,curr*2L);
	    String poss2 = helper(x,y,str+"W",cx-curr,cy,curr*2L);
	    String poss3 = helper(x,y,str+"N",cx,cy+curr,curr*2L);
	    String poss4 = helper(x,y,str+"S",cx,cy-curr,curr*2L);
	    int l1 = poss1.length();
	    int l2 = poss2.length();
	    int l3 = poss3.length();
	    int l4 = poss4.length();
	    int len = Math.min(l1,Math.min(l2, Math.min(l3,l4)));
	    if(len==l1){
	        return poss1;
	    }
	    if(len==l2){
	        return poss2;
	    }
	    if(len==l3){
	        return poss3;
	    }
	    else{
	        return poss4;
	    }
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int tt= s.nextInt();
		for(int test=1; test<=tt; test++) {
			long x = s.nextLong();
			long y = s.nextLong();
			if(Math.abs(x)%2L==0L && Math.abs(y)%2L==0L){
			    System.out.println("Case #"+test+": IMPOSSIBLE");
			    continue;
			}
			if(Math.abs(x)%2L==1L && Math.abs(y)%2L==1L){
			    System.out.println("Case #"+test+": IMPOSSIBLE");
			    continue;
			}
			String ans = helper(x,y,"",0L,0L,1L);
			System.out.println("Case #"+test+": "+ans);
		}
	}
}