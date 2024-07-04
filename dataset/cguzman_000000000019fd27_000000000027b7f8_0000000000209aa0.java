
import java.util.Scanner;

public class Solution {
	 
	public static void main(String[] args) {

		
		try {

			Scanner s = new Scanner(System.in); 
			
			int T = s.nextInt(); 
			
			for(int i = 1; i <= T; i++) {
				
				int N = s.nextInt();
				int K = s.nextInt();
				int R = 1;
			
				boolean possible = false;
				if(K < N*N) {
			        for (R = 1; R <= N && !possible; ++R) { 
			        	if(R*N == K) {
			        		possible = true;
			        		break;
			        	}
			        }
				}
				
		        if(!possible) {
					System.out.println("Case #"+i+": IMPOSSIBLE");
		        }else {
					System.out.println("Case #"+i+": POSSIBLE");

			        // A variable to control the  
			        // rotation point. 
			      
			        // Loop to print rows 
			        for (int row = 1; row <= N; row++) { 
			  
			            // This loops runs only after 
			            // first iteration of outer  
			            // loop. It prints 
			            // numbers from n to k 
			            int temp = R; 
			  
			            while (temp <= N) 
			            { 
			                System.out.print(temp + " "); 
			                temp++; 
			            } 
			      
			            // This loop prints numbers from 
			            // 1 to k-1. 
			            for (int j = 1; j < R; j++) 
			                System.out.print(j + " "); 
			      
			            R--; 
			            if(R==0)
			            	R = N;
			            System.out.println(); 
			        } 
		        }
		        	
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} 

	}
}
