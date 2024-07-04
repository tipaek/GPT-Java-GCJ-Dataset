import java.util.*;
class Box implements Comparable<Box>{
	int s,e,index;
	Box(int s, int e, int index){
		this.s=s;
		this.e=e;
		this.index=index;
	}
	public int compareTo(Box b) {
		return this.s-b.s;
	}
}
public class Solution {
	public static void main(String args[]) {
		Scanner in=new Scanner (System.in);
		int t=in.nextInt();
		int test=0;
		while(--t>=0) {
			int n=in.nextInt();
			ArrayList<Box> arr=new ArrayList<>();
			boolean flag=false;
			int end;
			char result[]=new char[n];
			
			for(int i=0;i<n;i++) {
				arr.add(new Box(in.nextInt(), in.nextInt(), i));
			}
			Collections.sort(arr);
			
			end=-1;
			for(int i=0;i<n;i++) {
				if(end<=arr.get(i).s) {
					result[arr.get(i).index]='C';
					end=arr.get(i).e;
					arr.set(i, new Box(-1,-1,-1));
				}
			}
			
			end=-1;
			for(int i=0;i<n;i++) {
				if(arr.get(i).s==-1)
					continue;
				
				if(end<=arr.get(i).s) {
					result[arr.get(i).index]='J';
					end=arr.get(i).e;
					arr.set(i, new Box(-1,-1,-1));
				}
				else {
					flag=true;
					break;
				}
			}
			
			if(flag)
				System.out.println("Case #"+(++test)+": IMPOSSIBLE");
			else 
				System.out.println("Case #"+(++test)+": "+new String(result));
		}
	}
}
