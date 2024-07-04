import java.util.*;
//Expogo
public class Solution {
	
	static class Pair{
		int x,y;
		String d;
		public Pair(int x , int y , String d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		
		for(int t=1;t<=T;t++){
			int x = s.nextInt();
			int y = s.nextInt();
			
			Queue<Pair> q = new LinkedList<CodejamRound1BQues1.Pair>();
			
			Pair p = new Pair(0,0,"");
			q.add(p);
			int i=1,flag=0,k=0;
			
			while(!q.isEmpty()){
				p = q.poll();
				
				if(p.x==x && p.y==y) {
					flag=1;
					break;
				}
				
				i=p.d.length()+1;
				
				int j = (int)Math.pow(2, i-1);
				
				if(p.x>50 || p.y>50) break;
				
				q.add(new Pair(p.x+j,p.y,p.d+"E"));
				q.add(new Pair(p.x,p.y+j,p.d+"N"));
				q.add(new Pair(p.x,p.y-j,p.d+"S"));
				q.add(new Pair(p.x-j,p.y,p.d+"W"));
				
				
			}
			
			if(flag==1){
				System.out.println("Case #"+t+": " + p.d);
			}else{
				System.out.println("Case #"+t+": IMPOSSIBLE");
			}
		}

	}

}