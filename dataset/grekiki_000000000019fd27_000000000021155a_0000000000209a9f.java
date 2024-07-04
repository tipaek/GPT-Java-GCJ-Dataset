import java.io.*;
import java.util.*;

public class Solution {
    public static void solve(BufferedReader in,int tcase) throws Exception{
	String s=in.readLine();
	StringBuilder ans=new StringBuilder();
	int depth=0;
	for(char c:s.toCharArray()) {
	    int t=c-'0';
	    if(t==depth) {
		ans.append(t);
	    }else if(t>depth) {
		while(t>depth) {
		    ans.append("(");
		    depth++;
		}
		ans.append(t);
	    }else if(t<depth) {
		while(t<depth) {
		    ans.append(")");
		    depth--;
		}
		ans.append(t);
	    }
	}
	for(int i=0;i<depth;i++) {
	    ans.append(")");
	}
	System.out.println("Case #"+tcase+": "+ans);
    }
    public static void main(String[] args) throws Exception {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	int t=Integer.parseInt(in.readLine());
	for(int tcase=1;tcase<=t;tcase++) {
	    solve(in,tcase);
	}
    }

}
