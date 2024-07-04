import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = s.nextInt();
		for(int ti=1;ti<=t;ti++)
		{
			int x = s.nextInt();
			int y = s.nextInt();
			
			String str = s.next();
			
			int flag = -1, dist = x+y;
			for(int i=0;i<str.length();i++) {
			    if(str.charAt(i)=='N') {
			        y++;
			    }
			    else if(str.charAt(i)=='S') {
			        y--;
			    }
			    else if(str.charAt(i)=='E') {
			        x++;
			    }
			    else {
			        x--;
			    }
			    if(Math.abs(x)+Math.abs(y)<=i+1) {
			        flag = i+1;
			        break;
			    }
			}
			
		    String ans = "";
		    if(flag==-1) {
		        System.out.println("Case #"+ti+": "+"IMPOSSIBLE");
		    }
		    else {
		        System.out.println("Case #"+ti+": "+flag);
		    }
			//System.out.println("Case #"+ti+": "+ans);
		}
	}
}