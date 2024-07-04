import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int testcase = 1; testcase <=T; testcase++) {
			st = new StringTokenizer(br.readLine());
			int s= Integer.parseInt(st.nextToken());
			int r= Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < s; j++) {
					char tmp = (char) ('A'+j); 
					sb.append(tmp);
				}
			}
			int answer=0;
			boolean xxx=true;
			ArrayList<int[]> list = new ArrayList<int[]>();
			for_j: for (int j = s-1; j >=0; j--) {
				while(true) {
					
					char tmp = (char) ('A'+j);
					sb.deleteCharAt(sb.length()-1);
					for (int i = sb.length()-1; i >=0 ; i--) {
						if(tmp == sb.charAt(i)) {
							sb.deleteCharAt(i);
						}else {
							break;
						}
					}
//					System.out.println(sb);
					int k= 0;
					if(xxx) {
						k= sb.indexOf(""+tmp);
						xxx=!xxx;
					}else {
						k= sb.lastIndexOf(""+tmp);
						xxx=!xxx;
					}
//					System.out.println("//"+tmp);
//					System.out.println(k);
					
					if(k==-1) break;
//					sb2.append((k+1)+" "+(sb.length()-(k+1))+"\n");
					list.add(new int[] {k+1, sb.length()-(k+1)});
					sb=new StringBuilder(sb.substring(k+1)+sb.substring(0,k+1));
//					System.out.println(sb);
					answer++;
				}
			}
			System.out.println("Case #"+testcase+": "+answer );
			for (int[] x :list) {
				System.out.println(x[0]+" "+x[1]);
			}
//			System.out.print(sb2);			
		}
	}
/*
6
2 2
3 2
2 3
4 2
2 4
4 3
3 4


 */
}