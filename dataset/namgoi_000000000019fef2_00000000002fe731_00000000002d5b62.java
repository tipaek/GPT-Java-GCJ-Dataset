import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int testcase = 1; testcase <=T; testcase++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder();
			boolean ispossible = true;
			String W="N";
			String A="E";
			String S="S";
			String D="W";
			if(x<0) {
				A="W";
				D="E";
				x=x*-1;
			}
			if(y<0) {
				W="S";
				S="N";
				y=y*-1;
			}
			while(x!=0 || y!=0) {
//				System.out.println("y%2"+(y%2));
				if(x%2==1 && y%2==0 ) {
					if((x>>1)%2==0 && (y>>1)%2==0 && (x>1 || y>1) ) {
						sb.append(D);
						x=(x>>1)+1;
						y=y>>1;
					} else if((x>>1)%2==1 && (y>>1)%2==1 && y!=0) {
						sb.append(D);
						x=(x>>1)+1;
						y=y>>1;
					}else {
						sb.append(A);
						x=x>>1;
						y=y>>1;
					}
				} else if(x%2==0 && y%2==1 ) {
					if((x>>1)%2==0 && (y>>1)%2==0 && (x>1 || y>1)) {
						sb.append(S);
						x=x>>1;
						y=(y>>1)+1;
					}else if((x>>1)%2==1 && (y>>1)%2==1 && x!=0) {
						sb.append(S);
						x=x>>1;
						y=(y>>1)+1;
					}else {
						sb.append(W);
						x=x>>1;
						y=y>>1;
					}
				}else {
					ispossible=false;
//					System.out.println(x +"/"+y+"/");
					break;
				}
//				System.out.println(x +"/"+y);
			}
			if(ispossible) {
				System.out.println("Case #"+testcase+": "+sb );	
			}else {
//				System.out.println(sb);
				System.out.println("Case #"+testcase+": IMPOSSIBLE" );
			}
			
		}
	}
	/*
10
2 3
-2 -3
3 0
-1 1
3 4
3 3
-2 -2
1 1
1 4
0 129
 
*/
}