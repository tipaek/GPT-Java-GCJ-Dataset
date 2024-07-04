import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Solution{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		int keis = Integer.valueOf(br.readLine().trim());
			
			long M = 1000000000L;
			int[] dy = {-1,0,1,0};
			int[] dx = {0,1,0,-1};
			String dir = "SENW";
			
			LinkedList<Cell> list = new LinkedList<Cell>();
			list.add(new Cell(0,0, ""));
			
			HashMap<Cell, String> hs = new HashMap<Cell, String>();
			for(int i = 0; i < 10; i++){
				int sz = list.size();
				for(int j = 0; j < sz; j++){
					Cell cur = list.removeFirst();
					if(hs.containsKey(cur)) continue;
					hs.put(cur, cur.str);
					long y = cur.y;
					long x = cur.x;
					for(int k = 0; k < 4; k++){
						long ny = y + (1 << i)*dy[k];
						long nx = x + (1 << i)*dx[k];
						if((ny > M) || (ny < -M) || (nx > M) || (nx < -M)) continue;
						list.add(new Cell(ny,nx, cur.str+""+dir.charAt(k)));
					}
				}
			}
			
			// out.println(hs.size());
			
		for(int kei = 0; kei < keis; kei++){
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			
			long X = Long.valueOf(st.nextToken());
			long Y = Long.valueOf(st.nextToken());
			
			Cell c = new Cell(Y, X, "");
			out.print("Case #"+(kei+1)+": ");
			if(hs.containsKey(c)){
				out.println(hs.get(c));
			}
			else{
				out.println("IMPOSSIBLE");
			}
		}
			
	}
	public static class Cell{
		long y, x;
		String str;
		public Cell(long a, long b, String c){
			y = a;
			x = b;
			str = c;
		}
		public int hashCode(){
			return (int)y;
		}
		public boolean equals(Object o){
			Cell c = (Cell)o;
			return x == c.x && y == c.y;
		}
	}
}