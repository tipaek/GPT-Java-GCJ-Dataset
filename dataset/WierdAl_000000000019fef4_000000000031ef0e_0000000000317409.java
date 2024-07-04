import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	
	 class Pair implements Comparable<Pair>{
		Integer x;
		Integer y;

		public Pair(Integer s,Integer e) {
			this.x = s;
			this.y = e;
		}

		@Override
		public int compareTo(Pair o) {
			return getDistance(this).compareTo(getDistance(o));
		}
		
		public Double getDistance(Pair o) {
			return Math.sqrt( o.x*o.x + o.y*o.y  ) ;
			
		}
	}
	
	 public static Map<Pair,Integer> pairIndexMap = new HashMap<>();
	
	public static void main(String[] args) {
		Solution pp = new Solution();
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t1 = scan.nextInt();
		
		for(int t=1;t<=t1;t++) {
			pairIndexMap.clear();
			int x = scan.nextInt();
			int y = scan.nextInt();
			String s = scan.nextLine();
			s=s.substring(1);
			
			int time=0;
			
			pairIndexMap.put(pp.new  Pair(x, y), time);
			time++;
			
			int min=Integer.MAX_VALUE;
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='N') {
					y++;
				}
				else if(s.charAt(i)=='S') {
					y--;
				}
				else if(s.charAt(i)=='E') {
					x++;
				}
				else if(s.charAt(i)=='W') {
					x--;
				}
				
				Pair temp = pp.new  Pair(x, y);
				
				pairIndexMap.put(temp, time);
				time++;
				
				if(pairIndexMap.get(temp)>=( abs(temp.x)+abs(temp.y))) {
					if(pairIndexMap.get(temp)<min) {
						min = pairIndexMap.get(temp);
					}
				}
			}
			
			
//			List<Pair> trace = new ArrayList<>(pairIndexMap.keySet());
//			
//			Collections.sort(trace);
//			
//			Pair closest = trace.get(0);
//			Integer timeRequired = pairIndexMap.get(closest);
			
			if( min!= Integer.MAX_VALUE) {
				System.out.println("Case #"+t+": "+min);
			}
			else {
				System.out.println("Case #"+t+": IMPOSSIBLE");
			}
			
			//System.out.print(x+" <-x y->"+y+ " , s="+s);
			
		}
		
		
		scan.close();
	}

  private static int abs(Integer x) {
    return (x>=0)?x:(-1*x);
  }
	
}

