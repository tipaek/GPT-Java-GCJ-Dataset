
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int a=0;a<t;a++){
		int x=sc.nextInt();
		int y=sc.nextInt();
		String m=sc.next();	
		Set<List<Integer>> visited=new HashSet<>();
		Queue<int[]> que=new LinkedList<>();
		
		
		que.offer(new int[] {0,0});
		visited.add(Arrays.asList(0,0));
		int time=0;
		boolean found=false;
		
		while(time<=m.length()) {
			int size=que.size();
			
			while(size-->0) {
				int curr[]=que.poll();
				int currx=curr[0];
				int curry=curr[1];
				
				if(currx==x && curry==y) {
					found=true;
					break;
				}
				
				if(visited.add(Arrays.asList(currx+1,curry))) {

					que.offer(new int[] {currx+1,curry});
				}
				if(visited.add(Arrays.asList(currx-1,curry))) {

					que.offer(new int[] {currx-1,curry});
				}if(visited.add(Arrays.asList(currx,curry+1))) {

					que.offer(new int[] {currx,curry+1});
				}if(visited.add(Arrays.asList(currx,curry-1))) {

					que.offer(new int[] {currx,curry-1});
				}
				que.offer(new int[] {currx,curry});
				}
			if(found)
				break;
			
			if(time<m.length()) {
				if(m.charAt(time)=='N')
					y+=1;
				else if(m.charAt(time)=='S')
					y-=1;
				else if(m.charAt(time)=='E')
					x+=1;
				else
					x-=1;
				}
				time++;
					
				
			}
		
		if(!found)
			System.out.println("Case #"+(a+1)+": "+"IMPOSSIBLE");
		else
			System.out.println("Case #"+(a+1)+": "+time);
		}
}
	}


