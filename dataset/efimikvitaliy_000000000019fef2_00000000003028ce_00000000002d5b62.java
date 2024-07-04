import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static class MyPair implements Comparable<MyPair> {
		int x;
		int y;
		String s;
		
		public MyPair(int x, int y, String s) {
			this.s = s;
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(MyPair o) {
			// TODO Auto-generated method stub
			return  s.length() - o.s.length();
		}
		
	}
	
	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int ZERO = 101;
		int A[][] = new int[210][210];
		
		for(int t = 1 ; t <= T; ++t) {
			
//			for(int i=0; i< 210; i++) {
//				for(int k=0; k<210; k++) {
//					A[i][k] = 0;
//				}
//			}
			
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int sum = Math.abs(x + y);
			int stwo = 0;
			boolean exist = sum % 2 == 1;
			
			
			if(!exist) {
				System.out.println("Case #" + t + ": IMPOSSIBLE");
				continue;
			}
			PriorityQueue<MyPair> q = new PriorityQueue<>();
			
			MyPair ps = new MyPair(0, 0, "");
			q.add(ps);
			MyPair r = null;
			
			int diff;
			
			while(!q.isEmpty()) {
				MyPair p = q.poll();
				
		
				
				if(p.x == x && p.y == y) {
					r = p;
					break;
				}
				else {
					
					if(p.s.length() <= 30) {
						// ok 
//						A[ZERO + p.x][ZERO + p.y] = 1;
						
						diff = (int) Math.pow(2, p.s.length());
						
						if(p.x + diff <= 1000000000 ) {
							q.add(new MyPair(p.x + diff, p.y, p.s + "E"));
						}
						
						if( p.y+ diff <= 1000000000) {
							q.add(new MyPair(p.x , p.y+ diff, p.s + "N"));
						}
						
						if(p.x - diff >= -1000000000 ) {
							q.add(new MyPair(p.x - diff, p.y, p.s + "W"));
						}
						
						if(p.y - diff >= -1000000000 ) {
							q.add(new MyPair(p.x , p.y- diff, p.s + "S"));
						}
					}
					else {
						
					}
					
					
					
					
					
				}
				
			}
			
			if(r != null) {
				System.out.println("Case #" + t + ": " + r.s);
			}
			else {
				System.out.println("Case #" + t + ": IMPOSSIBLE");
			}
			
			
		}
		
	}

}
