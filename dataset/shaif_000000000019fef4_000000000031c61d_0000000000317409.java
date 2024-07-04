
import java.util.*;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.io.IOException;
import java.util.ArrayList;
class Solution{
	static class pair implements Comparable<pair>{
        int price;
    int cls;
    pair(int name,int marks){
        this.price = name;
        this.cls = marks;
    }
    @Override
    public int compareTo(pair p){
        return this.price - p.price;
    }
    }
	public static void main(String[] args) throws IOException{
		long m=1000000007;
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine().trim());
		int g=1;
		for(int h=0;h<T;h++) {
			String s1[] = sc.nextLine().trim().split(" ");
			int x = Integer.parseInt(s1[0]);
			int y= Integer.parseInt(s1[1]);
			String path=s1[2];
			//System.out.println(s1[0]+" "+s1[1]+" "+s1[2]);
			int n=path.length();
			int cn=0;
			int cs=0;
			int ans=0;
			for(int i=0;i<n;i++) {
				if(path.charAt(i)=='N') {
					cn++;
				}
				else {
					cs++;
				}
				
			}
			int pos=cs-cn;
			int pos2=Math.abs(pos);
			if(pos<x || pos<y) {
				System.out.println("Case #"+g+": IMPOSSIBLE");
			}
			
			else if(pos>=0) {
				int left=pos-x;
				if(y>left) {
				int move=left/2;
				ans=x+move;
				}
				else {
					ans=x+left;
				}
				//System.out.println(x+" "+y+" "+move+" "+left);
				System.out.println("Case #"+g+": "+ans);
			}
			
			
				
			g++;
			
	    	
	  }
	}

}