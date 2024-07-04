import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int q = 1;q<=t ;q++){
			int x = in.nextInt();
			int y = in.nextInt();
			String st = in.next();
			int n = st.length();
			int ans = Integer.MAX_VALUE;
			for(int i=0;i<n;i++){
				if(st.charAt(i)=='N'){
					y+=1;
					
				}else if(st.charAt(i)=='S'){
					y-=1;
					
				}else if(st.charAt(i)=='E'){
					x+=1;
					
				}else if(st.charAt(i)=='W'){
					x-=1;
					
				}
				if(Math.abs(x)+Math.abs(y)<=(i+1)){
					ans = Math.min(ans, (i+1));
				}
			}
			if(ans==Integer.MAX_VALUE){
				System.out.println("Case #"+q+": IMPOSSIBLE");
			}else System.out.println("Case #"+q+": "+ans);
		}		
	}   
}