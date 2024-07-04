import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner input = new Scanner(System.in);
			int t = input.nextInt();
			for(int z=1;z<=t;z++) {
				
				int n = input.nextInt();
				int ar[][] = new int[n][n];
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						ar[i][j] = input.nextInt();
					}
				}
				int tra = 0;
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(i==j) {
							tra=tra+ar[i][j];
						}
					}
				}
				int cr=0,cc=0;
				for (int i = 0; i < ar.length; i++) { 
					  
		            // HashSet for current row 
		            HashSet<Integer> hs = new HashSet<>(); 
		  
		            // Traverse the row 
		            for (int j = 0; j < ar[i].length; j++) { 
		  
		                // Add all the values of the row in HashSet 
		                hs.add(ar[i][j]); 
		            } 
		  
		            // Check if size of HashSet = 1 
		            if (hs.size() <n) 
		                cr+=1; 
		        } 
				
				
				for(int i=0;i<n;i++) {
					HashSet<Integer> hsc = new HashSet<>();
					for(int j=0;j<n;j++) {
						
						hsc.add(ar[j][i]);
					}
					if (hsc.size() <n) 
		                cc+=1;
				}
				
				System.out.println("Case #"+z+": "+tra+" "+cr+" "+cc);
			}
		}catch(Exception e) {
			return;
		}
	}

}
