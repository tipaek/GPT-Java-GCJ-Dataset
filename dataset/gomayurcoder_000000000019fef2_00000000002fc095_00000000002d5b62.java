import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = s.nextInt();
		for(int ti=1;ti<=t;ti++)
		{
			long tx = s.nextLong();
			long ty = s.nextLong();
			
			int[] row = new int[64];
			int[] col = new int[64];
			
			boolean flag = true;
			
			long x = Math.abs(tx), y = Math.abs(ty);
			
			for(int i=0;x>0 || y>0;i++) {
				long bx = x%2, by = y%2;
				
				if(bx==0 && by==0) {
					flag = false;
					break;
				}
				else if(bx!=by) {
					if(bx==1) {
						row[i] = -1;
					}
					if(by==1) {
						col[i] = -1;
					}
				}
				else {
					if(i==0) {
						flag = false;
						break;
					}
					if(row[i-1]!=0) {
						row[i-1] = 1;
						x += 1;
						col[i] = -1;
					}
					else {
						col[i-1] = 1;
						y += 1;
						row[i] = -1;
					}
				}
				x = x/2;
				y = y/2;
			}
			
			if(!flag) {
				System.out.println("Case #"+ti+": "+"IMPOSSIBLE");
			}
			else {
				StringBuilder sb = new StringBuilder();
				for(int i=0;i<64;i++) {
					if(row[i]==0 && col[i]==0) {
						break;
					}
					if((row[i]==-1 && tx<0) || (row[i]==1 && tx>0)) {
						sb.append('W');
					}
					else if((row[i]==-1 && tx>0) || (row[i]==1 && tx<0)){
						sb.append('E');
					}
					else if((col[i]==-1 && ty<0) || (col[i]==1 && ty>0)) {
						sb.append('S');
					}
					else {
						sb.append('N');
					}
					//System.out.println(sb.toString()+"*");
				}
				String ans = sb.toString();
				System.out.println("Case #"+ti+": "+ans);
			}
		}
	}
}