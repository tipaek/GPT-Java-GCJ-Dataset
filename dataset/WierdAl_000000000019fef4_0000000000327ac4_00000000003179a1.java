

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
			if(this.x!=o.x) {
				return this.x.compareTo(o.x);
			}
			else return this.y.compareTo(o.y);
		}
		
		public Double getDistance(Pair o) {
			return Math.sqrt( o.x*o.x + o.y*o.y  ) ;
			
		}
	}
	
	public static void main(String[] args) {
		Solution pp = new Solution();
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t1 = scan.nextInt();
		// t1=1;
		
		for(int t=1;t<=t1;t++) {
			int u=scan.nextInt();
			//u=2
			
			Map<Pair, String> map = new HashMap<>();
			
			for(int i=1;i<=10000;i++) {
				int mi = scan.nextInt();
				
				String si = scan.nextLine();
				si=si.substring(1);
				
				Pair p = pp.new Pair(mi,i);
				map.put(p, si);
			}
			List<Pair> mis = new ArrayList<>(map.keySet());
			Collections.sort(mis);
			
			Character[] dic = new Character[10];
			
			for(Pair temp: mis) {
				//System.out.println("mi="+temp.x + " i="+temp.y+" ri="+map.get(temp));
				if(temp.x==1) {
					dic[1]=map.get(temp).charAt(0);
				}
				else if(temp.x==2) {
					if(map.get(temp).charAt(0)!=dic[1]) {
						dic[2]=map.get(temp).charAt(0);
					}
				}
				else if(temp.x==3) {
					if(map.get(temp).charAt(0)!=dic[1] && map.get(temp).charAt(0)!=dic[2]) {
						dic[3]=map.get(temp).charAt(0);
					}
				}
				else if(temp.x==4) {
					if(map.get(temp).charAt(0)!=dic[1] && map.get(temp).charAt(0)!=dic[2] && map.get(temp).charAt(0)!=dic[3]) {
						dic[4]=map.get(temp).charAt(0);
					}
				}
				else if(temp.x==5) {
					if(map.get(temp).charAt(0)!=dic[1] && map.get(temp).charAt(0)!=dic[2] && map.get(temp).charAt(0)!=dic[3]
							 && map.get(temp).charAt(0)!=dic[4]) {
						dic[5]=map.get(temp).charAt(0);
					}
				}
				else if(temp.x==6) {
					if(map.get(temp).charAt(0)!=dic[1] && map.get(temp).charAt(0)!=dic[2] && map.get(temp).charAt(0)!=dic[3]
							 && map.get(temp).charAt(0)!=dic[4] && map.get(temp).charAt(0)!=dic[5]) {
						dic[6]=map.get(temp).charAt(0);
					}
				}
				else if(temp.x==7) {
					if(map.get(temp).charAt(0)!=dic[1] && map.get(temp).charAt(0)!=dic[2] && map.get(temp).charAt(0)!=dic[3]
							 && map.get(temp).charAt(0)!=dic[4] && map.get(temp).charAt(0)!=dic[5] && map.get(temp).charAt(0)!=dic[6]) {
						dic[7]=map.get(temp).charAt(0);
					}
				}
				else if(temp.x==8) {
					if(map.get(temp).charAt(0)!=dic[1] && map.get(temp).charAt(0)!=dic[2] && map.get(temp).charAt(0)!=dic[3]
							 && map.get(temp).charAt(0)!=dic[4] && map.get(temp).charAt(0)!=dic[5] && map.get(temp).charAt(0)!=dic[6]
									 && map.get(temp).charAt(0)!=dic[7]) {
						dic[8]=map.get(temp).charAt(0);
					}
				}
				else if(temp.x==9) {
					if(map.get(temp).charAt(0)!=dic[1] && map.get(temp).charAt(0)!=dic[2] && map.get(temp).charAt(0)!=dic[3]
							 && map.get(temp).charAt(0)!=dic[4] && map.get(temp).charAt(0)!=dic[5] && map.get(temp).charAt(0)!=dic[6]
									 && map.get(temp).charAt(0)!=dic[7] && map.get(temp).charAt(0)!=dic[8]) {
						dic[9]=map.get(temp).charAt(0);
					}
				}
				else if(temp.x==10) {
					
					String ss = map.get(temp);
					if(ss.length()==2) {
						dic[0]=map.get(temp).charAt(1);
					}
				}
			}
			
			//String dicword = dic.toString();
				System.out.print("Case #"+t+": ");
				for(int i=0;i<10;i++) {
					System.out.print(dic[i]);
				}
				System.out.println();
			//System.out.print(x+" <-x y->"+y+ " , s="+s);
			
		}
		
		
		scan.close();
	}

	
}

