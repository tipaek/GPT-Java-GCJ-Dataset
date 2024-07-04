import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for(int i=1;i<=t;i++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int r =Integer.parseInt(st.nextToken());
			int s =Integer.parseInt(st.nextToken());
			System.out.println("Case #"+i+": "+ (r-1)*(s-1));
			for(int j=r;j>1;j--) {
				int temp1=j;
				int temp2 = j-1;
				for(int k=1;k<s;k++) {
					System.out.println(temp1+" "+temp2);
					temp1*=2;
					
				}
			}
			
		}

	}

}
