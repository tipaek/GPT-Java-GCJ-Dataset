import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution {
/* package codechef; // don't place package name! */
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int tt  =s.nextInt();
		for(int test=1; test<=tt; test++) {
			int ans = Integer.MAX_VALUE;
			int x = s.nextInt();
			int y = s.nextInt();
			String m = s.next();
			int min = 0;
			for(int i=0; i<m.length(); i++){
			    min++;
			    if(m.charAt(i)=='S'){
			        y--;
			    }
			    if(m.charAt(i)=='N'){
			        y++;
			    }
			    if(m.charAt(i)=='W'){
			        x--;
			    }
			    if(m.charAt(i)=='E'){
			        x++;
			    }
			    if(Math.abs(x)+Math.abs(y)<=min){
			        ans = Math.min(min,ans);
			    }
			}
			if(ans!=Integer.MAX_VALUE)
			System.out.println("Case #"+test+": " + ans);
			else
			System.out.println("Case #"+test+": IMPOSSIBLE");
		}
    }
} 