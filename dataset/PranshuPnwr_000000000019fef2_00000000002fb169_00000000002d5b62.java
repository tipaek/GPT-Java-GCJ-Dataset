import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		int k=1;
		while(t-->0){
			int x=scn.nextInt();
			int y=scn.nextInt();
			res(x,y,k);
			k++;
		}

	}
	public static void res(int x ,int y,int K){
		int count=0;
		LinkedList<pair> q =new LinkedList<>();
		StringBuilder sb1 =new StringBuilder();
		q.addLast(new pair(0,0,0,sb1));
         int i=0;
         int [][] dir ={{1,0},{-1,0},{0,1},{0,-1}};
         char []arr = {'N','S','E','W'};
		  HashMap<Integer,HashSet<Integer>> visited = new HashMap<>();
		  int gap = (x*x)+(y*y);
		while(q.size()>0){
			
			pair p =q.removeFirst();
			if((int)Math.pow(2,p.val)>gap){
				System.out.println("Case #"+K+": IMPOSSIBLE");
				return;
			}
			if(visited.containsKey(p.x)){
				HashSet<Integer> hs = visited.get(p.x);
				if(hs.contains(p.y)){
					continue;
				}
			}
			//System.out.println(p.x+"A"+p.y);
			if(p.x==x&& p.y==y){
				System.out.println("Case #"+K+": "+p.sb);
				return ;
			}
			 if(visited.containsKey(p.x)){
				 HashSet<Integer> hs = visited.get(p.x);
				  hs.add(p.y);
			 }else{
				 HashSet<Integer> hs =new HashSet<>();
				 hs.add(p.y);
				 visited.put(p.x, hs);
			 }
			 int val = (int)Math.pow(2,p.val);
			
	//	 System.out.println(p.val+"a");
			 for(int k=0;k<dir.length;k++){
				 int r= p.x+dir[k][1]*val;
				 int c = p.y+dir[k][0]*val;
				 StringBuilder sb = new StringBuilder();
				   sb.append(p.sb);
				   sb.append(arr[k]);
				 q.addLast(new pair(r,c,p.val+1,sb));
			 }
			  
			
		}
	}
	
	
	public static class pair{
		int x;int y;
		int val;
		StringBuilder sb =new StringBuilder();
		public pair(int x ,int y ,int val, StringBuilder sb){
			this.x=x;
			this.y=y;
			this.val=val;
			this.sb =sb;
			
		}
	}

}