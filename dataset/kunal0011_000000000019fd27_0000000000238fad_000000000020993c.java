

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); 
		int a=1;
		
		while(a<=t) {
			
			int n =Integer.parseInt(br.readLine());
			
			int[][] arr = new int[n][n];
			
			int trace =0;
			
			for(int i=0;i<n;i++) {
				
				String s[] = br.readLine().split(" ");
					
				for(int j=0;j<n;j++) {
					
					if(i==j) trace +=Integer.parseInt(s[j]);
					arr[i][j]=Integer.parseInt(s[j]);
				}
			}
			
			int rowcount=0;
			int colcount=0;
			for(int i=0;i<n;i++) {
				
				HashSet<Integer> rhs = new HashSet<>();
				HashSet<Integer> chs = new HashSet<>();
				for(int j=0;j<n;j++) {
					rhs.add(arr[i][j]);
					chs.add(arr[j][i]);
				}
				
				if(rhs.size()<n) rowcount++;
				if(chs.size()<n) colcount++;
			}
			
			System.out.println("Case #"+a+":"+" "+trace+" "+rowcount+" "+colcount);
			a++;
			
		}
		
	
	}

}
