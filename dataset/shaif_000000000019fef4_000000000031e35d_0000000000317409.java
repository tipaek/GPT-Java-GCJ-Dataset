
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
			int min=0;
			int y2=0;
			int flag=0;
			int y3=y;
			for(int i=0;i<n;i++) {
				if(path.charAt(i)=='N') {
					y3++;
				}
				else {
					y3--;
				}
				int pos=cs-cn;
				min++;
				if(min<x) {
					continue;
				}
				//System.out.println(y3);
				if(min==x) {
					ans+=x;
					if(y3==0) {
						flag=1;
						System.out.println("Case #"+g+": "+min);
					}
				}
				else {
					if(y3!=0 && y==0) {
						flag=0;
						//System.out.println("in false");
						break;
					}
					if(Math.abs(y3-y2)<=1) {
						flag=1;
						System.out.println("Case #"+g+": "+min);
						break;
					}
					else if(y3<0) {
						y2--;
					}
					else {
						y2++;
					}
					//System.out.println(y3+" "+y2);
					
				}
				
				
			}
			if(flag==0) {
				System.out.println("Case #"+g+": IMPOSSIBLE");
			}
			
			
			
				
			g++;
			
	    	
	  }
	}

}