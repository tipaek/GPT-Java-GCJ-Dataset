

import java.util.*;

public class Solution {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());
		
		for(int t=0; t<T; t++){
			StringBuilder ans = new StringBuilder();
			int X = Integer.parseInt(sc.next());
			int Y = Integer.parseInt(sc.next());
			
			if((X+Y) % 2 == 0){
				ans = new StringBuilder("IMPOSSIBLE");
			}else{
				for(int i=1; i<(int)Math.pow(4, 8); i++){
					int tmp_x = 0;
					int tmp_y = 0;
					String base = Integer.toString(i, 4);
					char[] path = base.toCharArray();
					StringBuilder tmp = new StringBuilder();
					for(int j=path.length-1; j>=0;j--){
						char d = path[j];
						int po = path.length-1 - j;
						int diff = (int)Math.pow(2, po);
						switch(d){
							case '0':
								//east
								tmp_x += diff;
								tmp.append('E');
								break;
							case '1':
								//west
								tmp_x -= diff;
								tmp.append('W');
								break;
							case '2':
								//N
								tmp_y += diff;
								tmp.append('N');
								break;
							case '3':
								//S
								tmp_y -= diff;
								tmp.append('S');
								break;
						}
						if(tmp_x == X && tmp_y == Y){
							ans = tmp;
							break;
						}
					}
				}
			}
			
			System.out.println("Case #"+(t+1)+": " + ans);
			
			
		}
		
		
		sc.close();
		return;
	}

	
}
