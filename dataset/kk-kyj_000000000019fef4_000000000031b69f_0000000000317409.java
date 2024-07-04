import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public interface Solution {
	static class Point {
		int x,y,cnt;
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int tc = Integer.parseInt(br.readLine());
			for(int t = 1; t <= tc; t++) {
				String[] info = br.readLine().split(" ");
				int x = Integer.parseInt(info[0]);
				int y = Integer.parseInt(info[1]);
				int cnt = info[2].length();
				for(int i = cnt-1; i >= 0; i--) {
					char dir = info[2].charAt(i);
					switch(dir) {
						case 'S':
							y--;
							break;
						case 'N':
							y++;
							break;
						case 'E':
							x--;
							break;
						case 'W':
							x++;
							break;
					}
				}
				
				int moveCnt = cnt+1;
				Queue<Point> q = new LinkedList<>();
				q.add(new Point(x,y,cnt));
				while(!q.isEmpty()) {
					Point p = q.poll();
					//System.out.println(p.x+","+p.y+">>"+p.cnt);
					if(p.cnt < 0) {
						continue;
					}
					if(p.x == 0 && p.y == 0) {
						moveCnt = p.cnt;
						break;
					}
					
					int c = p.cnt;
					int nx = p.x;
					int ny = p.y;
					if(nx != 0) {
						if(nx > 0) {
							q.add(new Point(nx-1,ny,c-1));
						} else {
							q.add(new Point(nx+1,ny,c-1));
						}
					} else if(ny != 0) {
						if(ny > 0) {
							q.add(new Point(nx,ny-1,c-1));
						} else {
							q.add(new Point(nx,ny+1,c-1));
						}
					}
				}
				if(moveCnt == 0) {
					moveCnt = cnt;
				}
				if(moveCnt > cnt) {
					System.out.println("Case #"+t+": IMPOSSIBLE");
				} else {
					System.out.println("Case #"+t+": "+moveCnt);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
