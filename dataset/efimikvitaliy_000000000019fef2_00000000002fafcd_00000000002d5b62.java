import java.util.PriorityQueue;
import java.util.Scanner;

public class Expogo {
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
			return s.length() - o.s.length();
		}
		
	}
	
	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int ZERO = 1001;
		
		for(int t = 1 ; t <= T; ++t) {
			
			int A[][] = new int[2000][2000];
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			
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
					
					diff = (int) Math.pow(2, p.s.length());
					
					if(p.x + diff <= 500 && A[ZERO + p.x + diff][ZERO + p.y] == 0) {
						A[ZERO + p.x + diff][ZERO + p.y] = 1;
						q.add(new MyPair(p.x + diff, p.y, p.s + "E"));
					}
					
					if( p.y+ diff <= 500 && A[ZERO + p.x ][ZERO + p.y+ diff] == 0) {
						A[ZERO + p.x ][ZERO + p.y+ diff] = 1;
						q.add(new MyPair(p.x , p.y+ diff, p.s + "N"));
					}
					
					if(p.x - diff >= -500 && A[ZERO + p.x - diff][ZERO + p.y] == 0) {
						A[ZERO + p.x - diff][ZERO + p.y] = 1;
						q.add(new MyPair(p.x - diff, p.y, p.s + "W"));
					}
					
					if(p.y - diff >= -500 && A[ZERO + p.x ][ZERO + p.y - diff] == 0) {
						A[ZERO + p.x ][ZERO + p.y - diff] = 1;
						q.add(new MyPair(p.x , p.y- diff, p.s + "S"));
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
